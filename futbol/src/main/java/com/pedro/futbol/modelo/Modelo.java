package com.pedro.futbol.modelo;

import java.util.List;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.entidades.Futbolista_Equipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Clase Modelo creada para almacenar datos de los equipos y los futbolistas
 * @author Pedro
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Modelo {

	/***
	 * Atributo equipo
	 */
	private String equipo;
	
	/***
	 * Atributo jugador
	 */
	private String jugador;
	
	/***
	 * Atributo de año de temporada
	 */
	private String anyo_temp;
	
}
