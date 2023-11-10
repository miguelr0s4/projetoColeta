package com.senac.sistemacoleta.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rota")
public class Rota {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rota_id")
	private Long id;
	
	@Column(name = "rota_inicio_time")
	private LocalDateTime inicio;
	
	@Column(name = "rota_otimizada")
	private int otimizada;
	
	@Column(name = "rota_status")
	private int status;
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "rota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RotaTrajeto> rotas;

	
}
