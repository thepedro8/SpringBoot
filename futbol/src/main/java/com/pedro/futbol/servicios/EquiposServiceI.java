package com.pedro.futbol.servicios;

import java.time.Year;
import java.util.List;

import com.pedro.futbol.entidades.Equipo;

public interface EquiposServiceI {
	public List<Equipo> obtenerTodosEquipos();

	public Equipo obtenerEquipoPorNombre(final String Nombre);
	
	public List<Equipo> obtenerNombreYAnyoCrea(final String nombre, final String anyoCrea);
	
	public List<Equipo> obtenerAnyoCreacion(String anyoCrea);

	public List<Equipo> obtenerEstadio(String nom_estadio);
	
	public List<Equipo> obtenerAnyoOEstadio(final String anyoCrea, final String nom_estadio);

	public List<Equipo> obtenerAnyoCreaYEstadio(final String anyoCrea, final String estadio);
	
	public List<Equipo> obtenerNombreYEstadio(final String nombre, final String estadio);

	public void eliminarEquipoPorId(final long IdEquipo);

	public void aniadirEquipo(final Equipo equipo);

	public void actualizarEquipo(final Equipo equipo);
}
