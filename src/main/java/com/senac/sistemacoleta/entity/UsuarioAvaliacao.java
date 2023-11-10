package com.senac.sistemacoleta.entity;

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
@Table(name = "usuario_avaliacao")
public class UsuarioAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_avaliacao_id")
    private Long id;

    @Column(name = "usuario_avaliacao_data")
    private String data;

    @Column(name = "usuario_avaliacao_nota")
    private Integer nota;

    @Column(name = "usuario_avaliacao_comentario")
    private String comentario;

    @Column(name = "usuario_avaliacao_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_avaliador_id", referencedColumnName = "usuario_id")
    private Usuario avaliador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_avaliado_id", referencedColumnName = "usuario_id")
    private Usuario avaliado;
}
