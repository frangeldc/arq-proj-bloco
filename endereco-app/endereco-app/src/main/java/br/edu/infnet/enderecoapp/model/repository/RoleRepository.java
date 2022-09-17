package br.edu.infnet.enderecoapp.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.enderecoapp.model.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

	static Role findByNome(String nome) {
		return null;
	}
}
