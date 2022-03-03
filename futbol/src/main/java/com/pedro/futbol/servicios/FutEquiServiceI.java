package com.pedro.futbol.servicios;

import java.util.List;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;


public interface FutEquiServiceI {
	
	public List<Futbolistas> obtenerTodosFutbolistas();
	
	public List<Equipo> obtenerTodosEquipos();
	
	public List<Futbolista_Equipo> obtenerTrayectoriaFutbolista(final long futbolista);
	
	public List<Futbolista_Equipo> obtenerHistoriaEq(final long idEquipo);
	
	public void aniadirTrayectoria(final Futbolista_Equipo futEqui);
}
