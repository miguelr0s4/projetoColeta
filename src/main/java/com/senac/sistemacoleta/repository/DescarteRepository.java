package com.senac.sistemacoleta.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.sistemacoleta.entity.Descarte;

public interface DescarteRepository extends JpaRepository<Descarte, Long>{
	
    List<Descarte> findByTempoDisponivelGreaterThan(LocalDateTime tempoDisponivel);
    
    List<Descarte> findByTempoDisponivelLessThan(LocalDateTime tempoDisponivel);

}
