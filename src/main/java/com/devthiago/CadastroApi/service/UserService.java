package com.devthiago.CadastroApi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devthiago.CadastroApi.dto.UserDto;
import com.devthiago.CadastroApi.model.User;
import com.devthiago.CadastroApi.repository.UserRepository;
import com.devthiago.CadastroApi.security.Token;
import com.devthiago.CadastroApi.security.TokenUtil;

@Service
public class UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository)  {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<User> listarUsuario() {
		List<User> list = (List<User>) userRepository.findAll();
		return list;
	}
	
	public User criarUsuario(User user) {
		String encoder = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encoder);
		User usuarioNovo = userRepository.save(user);
		return usuarioNovo;
	}
	
	public User editarUsuario(User user) {
		String encoder = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encoder);
		User usuarioNovo = userRepository.save(user);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Integer id) {
		userRepository.deleteById(id);
		return true;
	}

	public Boolean validarSenha(User usuario) {
		String senha = userRepository.getById(usuario.getId()).getPassword();
		Boolean valid = passwordEncoder.matches(usuario.getPassword(), senha);
		return valid;
	}

	public Token gerarToken(@Valid UserDto usuario) {
		
		User user = userRepository.findBynomeOrEmail(usuario.getNome(), usuario.getEmail());
		if (user != null) {
			Boolean valid = passwordEncoder.matches(usuario.getPassword(), user.getPassword());
			if (valid) {
				return new Token(TokenUtil.createToken(user));
			}
		}
		return null;
	}

	
}
