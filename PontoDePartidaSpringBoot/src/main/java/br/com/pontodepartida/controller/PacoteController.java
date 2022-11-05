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
import br.com.pontodepartida.repository.PacotePartidaRepository;

@Controller
@RequestMapping("/pacote")
public class PacoteController {

	@Autowired
	private PacotePartidaRepository pacotePartidaRepository;

	@GetMapping
	public ModelAndView listar() { // listar é a pagina html que receberá o resultado
		ModelAndView modelAndView = new ModelAndView("pacote/listaPacote.html");

		List<PacotePartida> pacote = pacotePartidaRepository.findAll();
		modelAndView.addObject("pacote", pacote);

		return modelAndView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {

		ModelAndView modelAndView = new ModelAndView("pacote/createPacote");
		modelAndView.addObject("pacote", new PacotePartida());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(PacotePartida pacote) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacote");
		pacotePartidaRepository.save(pacote);
		return modelAndView;
	}

	@GetMapping("/{idPacote}/excluir")
	public ModelAndView excluir(@PathVariable Long idPacote) {

		ModelAndView modelAndView = new ModelAndView("redirect:/pacote");
		pacotePartidaRepository.deleteById(idPacote);
		return modelAndView;
	}

	@GetMapping("/{idPacote}/editar")
	public ModelAndView editar(@PathVariable Long idPacote) {
		ModelAndView modelAndView = new ModelAndView("pacote/updatePacote");// ???????????????????????????
		PacotePartida pacote = pacotePartidaRepository.getReferenceById(idPacote);
		modelAndView.addObject("pacote", pacote);
		return modelAndView;
	}

	@PostMapping("/{idPacote}/editar")
	public ModelAndView editar(PacotePartida pacote) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacote");
		pacotePartidaRepository.save(pacote);
		return modelAndView;
	}

}
