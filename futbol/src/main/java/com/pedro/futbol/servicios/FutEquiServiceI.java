package com.pedro.futbol.servicios;

import java.util.List;

import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;


public interface FutEquiServiceI {
	public List<Futbolistas> obtenerTodosFutbolistas();
	
	public List<Futbolista_Equipo> obtenerTrayectoriaFutbolista(final long futbolista);
}
