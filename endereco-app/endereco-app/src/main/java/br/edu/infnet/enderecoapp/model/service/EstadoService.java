package br.edu.infnet.enderecoapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.enderecoapp.clients.IBGEClient;
import br.edu.infnet.enderecoapp.model.domain.Estado;
import br.edu.infnet.enderecoapp.model.domain.Municipio;

@Service
public class EstadoService {

	@Autowired
	private IBGEClient IBGEClient;
	
	public List<Estado> obterLista() {

		return IBGEClient.obterLista();
	}
	
	public List<Municipio> obterPorUF(String UF) {
		return IBGEClient.obterPorUF(UF);

	}
	
}
