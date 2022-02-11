package com.pedro.futbol.entidades;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Equipos")
public class Equipo implements Serializable{


	/** Id del equipo (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** Nombre del equipo (PK) */
	@Column(name = "Nombre", nullable = false)
	private String nombre;

	
	/** Año de creacion */
	@Column(name = "Año_creacion", nullable = false)
	private Year anyoCrea;

	/** Nombre del estadio */
	@Column(name = "Estadio", nullable = false)
	private String estadio;

	
	@OneToMany(mappedBy = "equipo")
    private List<Futbolista_Equipo> futbolistaEquipo;
}
