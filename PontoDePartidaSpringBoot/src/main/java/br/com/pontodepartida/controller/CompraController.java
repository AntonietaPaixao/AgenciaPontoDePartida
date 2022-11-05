package br.com.pontodepartida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pontodepartida.model.Pessoa;
import br.com.pontodepartida.model.Compra;
import br.com.pontodepartida.repository.PessoaRepository;
import br.com.pontodepartida.repository.CompraRepository;
import br.com.pontodepartida.utils.SenhaUtils;

@Controller
@RequestMapping("/compra")
public class CompraController {
	@Autowired
	private CompraRepository compraRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("compras/listaCompra");
		
		List<Compra> compras = compraRepository.findAll();
		modelAndView.addObject("compras", compras);
		
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "compra"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("compras/createCompra");
		modelAndView.addObject("compras", new Compra());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Compra compra) {
		ModelAndView ModelAndView = new ModelAndView("redirect:/compra");
		compraRepository.save(compra);
		return ModelAndView;
	}
	
	@GetMapping("/{id_compra}/excluir")
	public ModelAndView excluir(@PathVariable Long id_compra) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compra");
		compraRepository.deleteById(id_compra);
		return modelAndView;
	}
	
	@GetMapping("/{id_compra}/editar")
	public ModelAndView editar(@PathVariable Long id_compra) {
		ModelAndView modelAndView = new ModelAndView("compras/updateCompra");
		Compra compra = compraRepository.getReferenceById(id_compra);
		modelAndView.addObject("compras", compra);
		return modelAndView;
	}
	
	@PostMapping("/{id_compra}/editar")
	public ModelAndView editar(Compra compra) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compras");
		compraRepository.save(compra);
		return modelAndView;
	}
}