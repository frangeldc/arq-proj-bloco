package br.edu.infnet.enderecoapp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.enderecoapp.model.domain.Estado;
import br.edu.infnet.enderecoapp.model.domain.Municipio;

//https://servicodados.ibge.gov.br/api/v1/localidades/estados
//https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios


@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "IBGEClient")
public interface IBGEClient {
	
	@GetMapping(value = "/estados")
	public List<Estado> obterLista();
	
	@GetMapping(value = "estados/{UF}/municipios")
	public List<Municipio> obterPorUF(@PathVariable String UF);

	
//	@GetMapping(value = "/{cep}/microrregioes")
//	public Endereco obterPorCep(@PathVariable String cep);

}
