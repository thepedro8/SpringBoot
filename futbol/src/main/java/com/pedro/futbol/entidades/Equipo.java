package com.pedro.futbol.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Clase Equipo donde se encuentran las propiedades del objeto
 * @author Pedro
 */
@Entity
@Table(name = "Equipos")
@Data @AllArgsConstructor @NoArgsConstructor
public class Equipo implements Serializable{


	/***
	 *  Id del equipo (PK) 
	 */  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	/***
	 *  Nombre del equipo (PK) 
	 */
	@Column(name = "Nombre", length = 31, nullable = false)
	private String nombre;

	
	/***
	 *  Año de creacion 
	 */
	@Column(name = "Año_creacion", length=4, nullable = false)
	private String anyoCrea;

	/***
	 * Nombre del estadio 
	 */
	@Column(name = "Estadio", length = 31,nullable = false)
	private String estadio;

	
	/***
	 * Lista de futbolista_equipo
	 */
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
	private List<Futbolista_Equipo> futbolistaEquipo;
}
