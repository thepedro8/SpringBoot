package com.pedro.futbol.modelo;

import java.util.List;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.entidades.Futbolista_Equipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Modelo {

	private String equipo;
	private String jugador;
	private String anyo_temp;
	
}
