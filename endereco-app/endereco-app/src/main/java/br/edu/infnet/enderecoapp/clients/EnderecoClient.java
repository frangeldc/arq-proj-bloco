package br.edu.infnet.enderecoapp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.enderecoapp.model.domain.Endereco;

@FeignClient("API-ENDERECO")
public interface EnderecoClient {

	@GetMapping(value = "/api/endereco/listar")
	public List<Endereco> obterLista();

	@PostMapping(value = "/api/endereco/incluir")
	public void incluir(@RequestBody Endereco endereco);

	@DeleteMapping(value = "/api/endereco/{id}/excluir")
	public void excluir(@PathVariable Integer id);

	@GetMapping(value = "/api/endereco/{cep}")
	public Endereco obterPorCep(@PathVariable String cep);

}
