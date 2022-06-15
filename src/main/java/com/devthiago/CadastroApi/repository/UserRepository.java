package com.devthiago.CadastroApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devthiago.CadastroApi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {


	public User findBynomeOrEmail(String nome, String email);

	

}
