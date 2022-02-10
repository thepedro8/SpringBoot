package com.pedro.futbol.entidades;

import java.io.Serializable;


import javax.persistence.*;

import java.time.Year;

@Entity
public class Futbolista_Equipo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** Id del futbolista (PK) */
	@ManyToOne
    @JoinColumn(name = "futbolista_id")
	private Futbolistas futbolista;
	
	/** Nombre del equipo (PK) */
	@ManyToOne
    @JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	
	@Column(name = "Anyo_temporada")
	/** Año de temporada */
	private Year anyo_temp;
	
}
