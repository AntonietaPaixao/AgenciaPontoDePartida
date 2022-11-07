package br.com.pontodepartida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pontodepartida.model.Permissao;
import br.com.pontodepartida.repository.PermissaoRepository;

@Controller
@RequestMapping("/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@GetMapping
	public ModelAndView listar() { // listar é a pagina html que receberá o resultado
		ModelAndView modelAndView = new ModelAndView("permissao/listaPermissao.html");

		List<Permissao> permissao = permissaoRepository.findAll();
		modelAndView.addObject("permissao", permissao);

		return modelAndView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {

		ModelAndView modelAndView = new ModelAndView("permissao/createPermissao");
		modelAndView.addObject("permissao", new Permissao());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Permissao permissao) {
		ModelAndView modelAndView = new ModelAndView("redirect:/permissao");
		permissaoRepository.save(permissao);
		return modelAndView;
	}

	@GetMapping("/{idPermissao}/excluir")
	public ModelAndView excluir(@PathVariable Long idPermissao) {

		ModelAndView modelAndView = new ModelAndView("redirect:/permissao");
		permissaoRepository.deleteById(idPermissao);
		return modelAndView;
	}

	@GetMapping("/{idPermissao}/editar")
	public ModelAndView editar(@PathVariable Long idPermissao) {
		ModelAndView modelAndView = new ModelAndView("permissao/updatePermissao");// ???????????????????????????
		Permissao permissao = permissaoRepository.getReferenceById(idPermissao);
		modelAndView.addObject("permissao", permissao);
		return modelAndView;
	}

	@PostMapping("/{idPermissao}/editar")
	public ModelAndView editar(Permissao permissao) {
		ModelAndView modelAndView = new ModelAndView("redirect:/permissao");
		permissaoRepository.save(permissao);
		return modelAndView;
	}

}
