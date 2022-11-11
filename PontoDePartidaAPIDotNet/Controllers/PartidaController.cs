using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure.Internal;
using PontoDePartidaAPIDotNet.Models;

namespace PontoDePartidaAPIDotNet.Controllers
{
	[Route("api/[controller]")]
	[ApiController]
	public class PartidaController : ControllerBase
	{
		private readonly PontoPartidaDBContext _context;

		public PartidaController(PontoPartidaDBContext context)
		{
			_context = context;
		}

		// GET:  LISTA TODOS AS PARTIDAS
		[HttpGet]
		public IEnumerable<Partida> GetPartida()
		{
			return _context.Partida;
		}

		// GET: LISTA PARTIDA POR ID
		[HttpGet("{id}")]
		public IActionResult GetPartidaPorId(int id)
		{
			Partida partida = _context.Partida.SingleOrDefault(modelo => modelo.PartidaId == id);
			if (partida == null)
			{
				return NotFound();
			}
			return new ObjectResult(partida);
		}

		//POST:  CRIA UM NOVA PARTIDA
		[HttpPost]
		public IActionResult CriarPartida(Partida item)
		{
			if (item == null)
			{
				return BadRequest();
			}

			_context.Partida.Add(item);
			_context.SaveChanges();
			return new ObjectResult(item);

		}

		//PUT: ATUALIZA UMA PARTIDA EXISTENTE
		[HttpPut("{id}")]
		public IActionResult AtualizaPartida(int id, Partida item)
		{
			if (id != item.PartidaId)
			{
				return BadRequest();
			}
			_context.Entry(item).State = EntityState.Modified;//Verifica se realmente houve modificações no objeto
			_context.SaveChanges();

			return new NoContentResult();
		}

		//DELETE: APAGA UMA PARTIDA POR ID
		[HttpDelete("{id}")]
		public IActionResult DeletaPartida(int id)
		{
			var partida = _context.Partida.SingleOrDefault(m => m.PartidaId == id);

			if (partida == null)
			{
				return BadRequest();
			}

			_context.Partida.Remove(partida);
			_context.SaveChanges();
			return Ok(partida);
		}

	}
}





