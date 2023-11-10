package com.senac.sistemacoleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.sistemacoleta.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
