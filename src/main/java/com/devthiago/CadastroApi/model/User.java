package com.devthiago.CadastroApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatorio")
	@Column(name = "name", length = 200, nullable = false)
	private String nome;
	
	@Email(message = "Insira um email válido!")
	@NotBlank(message = "O email é obrigatorio")
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@NotBlank(message = "a senha é obrigatoria")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String password;
	
	@NotBlank(message = "O cep é obrigatorio")
	@Column(name = "cep", length = 15, nullable = false)
	private String cep;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@NotBlank(message = "a data de nascimento é obrigatoria")
	@Column(name = "nascimento", length = 15, nullable = false)
	private String nascimento;
	
	public User() {}

	public User(Integer id, String nome, String email, String password, String cep, String nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.cep = cep;
		this.nascimento = nascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	
	
}
