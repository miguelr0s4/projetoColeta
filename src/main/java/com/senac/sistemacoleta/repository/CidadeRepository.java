package com.senac.sistemacoleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senac.sistemacoleta.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
