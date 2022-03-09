package com.pedro.futbol.entidades;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

/***
 * Clase Futbolista_Equipo donde se encuentran las propiedades del objeto
 * @author Pedro
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Futbolista_Equipo implements Serializable{
	

	
	private static final long serialVersionUID = 1L;

	/**
	 * Id de la tupla
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/***
	 *  Id del futbolista (PK) 
	 */
	@ManyToOne
    @JoinColumn(name = "futbolista_id")
	private Futbolistas futbolista;
	
	/***
	 *  Nombre del equipo (PK) 
	 */
	@ManyToOne
    @JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	/***
	 * Año de temporada
	 */
	@Column(name = "Anyo_temporada", length = 4, nullable = false)
	private String anyo_temp;
	
}
