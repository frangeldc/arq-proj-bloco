package br.edu.infnet.enderecoapp.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.edu.infnet.enderecoapp.model.domain.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);

		if (usuario == null) {	
			throw new UsernameNotFoundException("O usuario " + username + "nao foi encontrado.");		
		} else {
			return usuario;
		}
	}

}
