package br.edu.infnet.enderecoapp.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.enderecoapp.model.domain.Endereco;
import br.edu.infnet.enderecoapp.model.service.EnderecoService;

@Controller
public class EnderecoController {
	private static final Logger LOGGER = Logger.getLogger(EnderecoController.class.getName());
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(value = "/enderecos")
	public String telaLista(Model model) {
		
		model.addAttribute("lista", enderecoService.obterLista());
		
		return "endereco/lista";
	}

	@GetMapping(value = "/endereco")
	public String telaCadastro() {
		return "endereco/cadastro";
	}

	@PostMapping(value = "/endereco")
	public String buscar(Model model, @RequestParam String cep) {
		
		Endereco endereco = enderecoService.obterPorCep(cep);
		
		model.addAttribute("endereco", endereco);
		
		return "endereco/cadastro";
	}

	@PostMapping(value = "/endereco/incluir")
	public String incluir(Endereco endereco) {
		LOGGER.info("Incluir endereco chamado");

		enderecoService.incluir(endereco);
		
		return "redirect:/enderecos";
	}

//	@DeleteMapping(value = "/endereco/{id}/excluir")
	@GetMapping(value = "/endereco/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		LOGGER.info("Excluir endereco chamado");
		enderecoService.excluir(id);
		
		return "redirect:/enderecos";
	}
}
