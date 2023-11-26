package com.senac.sistemacoleta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.sistemacoleta.entity.MaterialTipo;

public interface MaterialTipoRepository extends JpaRepository<MaterialTipo, Long>{
    List<MaterialTipo> findByIdIn(List<Long> ids);
}
