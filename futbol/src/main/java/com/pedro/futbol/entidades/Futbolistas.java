package com.pedro.futbol.entidades;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Futbolistas")
@Data @AllArgsConstructor @NoArgsConstructor
public class Futbolistas implements Serializable{
	/** Id del futbolista (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	/** Nombre del futbolista */
	@Column(name = "Nombre", nullable = false)
	private String nombre;

	/** Año de nacimiento */
	@Column(name = "Año_nacimiento", nullable = false)
	private String anyoNac;
	
	/** Nacionalidad del futbolista */
	@Column(name = "Nacionalidad", nullable = false)
	private String nacionalidad;
	
	/** NIF del futbolista */
	@Column(name = "NIF", nullable = false)
	private String nif;
	
	@OneToMany(mappedBy = "futbolista", cascade = CascadeType.REMOVE)
	private List<Futbolista_Equipo> futbolistaEquipo;
}
