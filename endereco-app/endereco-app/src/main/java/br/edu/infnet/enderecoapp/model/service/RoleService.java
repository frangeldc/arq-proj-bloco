package br.edu.infnet.enderecoapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.enderecoapp.model.domain.Role;
import br.edu.infnet.enderecoapp.model.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void incluir(Role role) {
		roleRepository.save(role);
	}
	
	public List<Role> obterLista() {
		return (List<Role>)roleRepository.findAll();
	}
	
	public Role obterPorNome(String nome) {
		Role role = RoleRepository.findByNome(nome);
		return role;
	}
	
	}