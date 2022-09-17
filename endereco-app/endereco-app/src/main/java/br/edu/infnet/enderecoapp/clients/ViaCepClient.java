package br.edu.infnet.enderecoapp.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.enderecoapp.model.domain.Endereco;

@FeignClient(url = "viacep.com.br/ws", name = "viaCepClient")
public interface ViaCepClient {

	@GetMapping(value = "/{cep}/json")
	public Endereco obterPorCep(@PathVariable String cep);

}
