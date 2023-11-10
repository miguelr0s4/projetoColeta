package com.senac.sistemacoleta.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rota_trajeto")
public class RotaTrajeto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rota_trajeto_id")
	private Long id;
	
	@Column(name = "acordo_coleta_ordem")
	private int ordem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rota_id")
	private Rota rota;
	
	@JoinColumn(name = "coleta_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private AcordoColeta acordo;
}
