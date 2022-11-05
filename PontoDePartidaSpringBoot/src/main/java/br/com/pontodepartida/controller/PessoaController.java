package br.com.pontodepartida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.pontodepartida.model.Pessoa;
import br.com.pontodepartida.model.Permissao;
import br.com.pontodepartida.repository.PessoaRepository;
import br.com.pontodepartida.repository.PermissaoRepository;
import br.com.pontodepartida.security.WebConfigSecurity;
import br.com.pontodepartida.utils.SenhaUtils;

@Controller
@RequestMapping(value = "/pessoas")
public class PessoaController {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private WebConfigSecurity passwordEncoder;
	
	//GET
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pessoa/listaPessoa");
		List<Pessoa> pessoa = pessoaRepository.findAll();
		modelAndView.addObject("pessoas", pessoa);
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "pessoa"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("pessoas/createPessoa");
		modelAndView.addObject("pessoa", new Pessoa());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Pessoa pessoa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/createPessoa");
		String senha = SenhaUtils.encode(pessoa.getSenha());
		pessoa.setSenha(senha);
		pessoaRepository.save(pessoa);
		return modelAndView;
	}
	
	@GetMapping("/{idPessoa}/excluir")
	public ModelAndView excluir(@PathVariable Long idPessoa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pessoas");
		pessoaRepository.deleteById(idPessoa);
		return modelAndView;
	}
	
	@GetMapping("/{idPessoa}/editar")
	public ModelAndView update(@PathVariable Long idPessoa) {
		ModelAndView modelAndView = new ModelAndView("pessoas/updatePessoa");
		Pessoa pessoa = pessoaRepository.getReferenceById(idPessoa);
		modelAndView.addObject("pessoas", pessoa);
		return modelAndView;
	}
	
	@PostMapping("/{idPessoa}/editar")
	public ModelAndView update(Pessoa pessoa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pessoa");
		String senha = SenhaUtils.encode(pessoa.getSenha());
		pessoa.setSenha(senha);
		pessoaRepository.save(pessoa);
		return modelAndView;
	}
}