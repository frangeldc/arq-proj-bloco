package br.edu.infnet.enderecoapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.enderecoapp.model.domain.Usuario;
import br.edu.infnet.enderecoapp.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public void incluir(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	};
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	};

	public Usuario autenticar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario != null && usuario.getSenha().equals(senha)) {
			return usuario;
		}
			return null;

	};

	
}
