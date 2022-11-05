package br.com.pontodepartida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/createCliente")
	public String createCliente() {
		return "createCliente";
	}
	
	@GetMapping("/createUsuario")
	public String createUsuario() {
		return "createUsuario";
	}

	@GetMapping("/pacotes")
	public String pacotes() {
		return "pacotes";
	}

	@GetMapping("/promocoes")
	public String promocoes() {
		return "promocoes";
	}

}
