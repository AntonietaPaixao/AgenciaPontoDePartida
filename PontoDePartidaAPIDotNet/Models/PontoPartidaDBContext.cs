using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;

namespace PontoDePartidaAPIDotNet.Models
{
	public class PontoPartidaDBContext : DbContext
	{
		public PontoPartidaDBContext(DbContextOptions<PontoPartidaDBContext> options)
		: base(options)
		{ }

		public DbSet<Partida> Partida { get; set; }//tabelas gereciasdas
	}
}