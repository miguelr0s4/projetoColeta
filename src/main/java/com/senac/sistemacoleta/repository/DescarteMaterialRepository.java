package com.senac.sistemacoleta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.sistemacoleta.entity.Descarte;
import com.senac.sistemacoleta.entity.DescarteMaterial;

public interface DescarteMaterialRepository extends JpaRepository<DescarteMaterial, Long>{


	List<DescarteMaterial> findByQuantidadeGreaterThan(Double quantidade);

}
