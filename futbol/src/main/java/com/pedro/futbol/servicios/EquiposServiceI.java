package com.pedro.futbol.servicios;

import java.time.Year;
import java.util.List;

import com.pedro.futbol.entidades.Equipo;

public interface EquiposServiceI {
	public List<Equipo> obtenerTodosEquipos();

	public Equipo obtenerEquipoPorNombre(final String Nombre);
	
	public Equipo obtenerEquipoPorId(final long id);
	
	public List<Equipo> obtenerAnyoCreacion(String anyoCrea);

	public List<Equipo> obtenerEstadio(String nom_estadio);

	public List<Equipo> obtenerAnyoCreaYEstadio(final String anyoCrea, final String estadio);
	
	public void eliminarEquipoPorId(final long IdEquipo);

	public void aniadirEquipo(final Equipo equipo);

	public void actualizarEquipo(final Equipo equipo);
}
