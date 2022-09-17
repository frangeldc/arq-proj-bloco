package br.edu.infnet.enderecoapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.enderecoapp.clients.EnderecoClient;
import br.edu.infnet.enderecoapp.clients.ViaCepClient;
import br.edu.infnet.enderecoapp.model.domain.Endereco;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private ViaCepClient viaCepClient;

	public List<Endereco> obterLista() {
		return enderecoClient.obterLista();
	}

	@CircuitBreaker(name = "cepService", fallbackMethod = "fallbackObeterPorCep")
	public Endereco obterPorCep(String cep) {

		Endereco endereco = enderecoClient.obterPorCep(cep);
		// Endereco endereco = viaCepClient.obterPorCep(cep);

		if (endereco == null) {
			return new Endereco(cep);
		} else {
			return endereco;
		}
	}

	public Endereco fallbackObterPorCep(Exception e) {
		System.out.println("Obter por CEP recuperado... " + e.getMessage());
		return new Endereco();

	}

	public void incluir(Endereco endereco) {
		enderecoClient.incluir(endereco);
	}

	public void excluir(Integer id) {
		enderecoClient.excluir(id);
	}

}
