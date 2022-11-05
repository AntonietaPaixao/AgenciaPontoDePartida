package br.com.pontodepartida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pontodepartida.model.PacotePartida;
import br.com.pontodepartida.repository.PartidaRepository;

@Controller
@RequestMapping("/partida")
public class PartidaController {

	@Autowired
	private PartidaRepository partidaRepository;

	@GetMapping
	public ModelAndView listar() { // listar é a pagina html que receberá o resultado
		ModelAndView modelAndView = new ModelAndView("partida/listaPartida.html");

		List<PacotePartida> partida = partidaRepository.findAll();
		modelAndView.addObject("partida", partida);

		return modelAndView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {

		ModelAndView modelAndView = new ModelAndView("partida/cadastraPartida");
		modelAndView.addObject("partida", new PacotePartida());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(PacotePartida partida) {
		ModelAndView modelAndView = new ModelAndView("redirect:/partida");
		partidaRepository.save(partida);
		return modelAndView;
	}

	@GetMapping("/{idPartida}/excluir")
	public ModelAndView excluir(@PathVariable Long idPartida) {

		ModelAndView modelAndView = new ModelAndView("redirect:/partida");
		partidaRepository.deleteById(idPartida);
		return modelAndView;
	}

	@GetMapping("/{idPartida}/editar")
	public ModelAndView editar(@PathVariable Long idPartida) {
		ModelAndView modelAndView = new ModelAndView("partida/updatePartida");// ???????????????????????????
		PacotePartida partida = partidaRepository.getReferenceById(idPartida);
		modelAndView.addObject("partida", partida);
		return modelAndView;
	}

	@PostMapping("/{idPartida}/editar")
	public ModelAndView editar(PacotePartida partida) {
		ModelAndView modelAndView = new ModelAndView("redirect:/partida");
		partidaRepository.save(partida);
		return modelAndView;
	}

}
