package com.rianerick.logistica.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)// criar hashCode apenas no atribudo 1/2
@Entity
public class Entrega {
	
// 2/2
 @EqualsAndHashCode.Include
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @ManyToOne // muitos para 1
 private Cliente cliente;
 
 @Embedded// pesquisar sobre
 private Destinatario destinatario;
 
 private BigDecimal taxa;
 
 @Enumerated(EnumType.STRING)
 private StatusEntrega status;
 
 private LocalDateTime dataPedido;
 
 private LocalDateTime dataFinalizacao;
 
 
 
 
}
