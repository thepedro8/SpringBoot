package com.pedro.futbol.servicios;

import java.util.List;

import com.pedro.futbol.entidades.Futbolistas;


public interface FutbolistasServiceI {
	public List<Futbolistas> obtenerTodosFutbolistas();
	
	//public List<Futbolistas> obtenerFutbolistasPorNifONacionalidadOAnyoNac(final String nif, final String nacionalidad, final String anyoNac);

	public Futbolistas obtenerFutbolistaPorId(final long id);
	
	public Futbolistas obtenerFutbolistaPorNombre(final String Nombre);
	
	public Futbolistas obtenerFutbolistaPorNif(final String Nif);
	
	public List<Futbolistas> obtenerFutbolistasPorAnyoNac(final String anyoNac);
	
	public List<Futbolistas> obtenerFutbolistasPorNacionalidad(final String nacionalidad);

	public List<Futbolistas> obtenerFutbolistasPorNombreYAnyoNac(final String nombre, final String anyoNac);
	
	public List<Futbolistas> obtenerFutbolistasPorNombreYNacionalidad(final String nombre, final String nacionalidad);
	
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNacionalidad(final String anyoNac, final String nacionalidad);
	
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNif(final String anyoNac, final String nif);
	
	public List<Futbolistas> obtenerFutbolistasPorNifYNacion(final String nif, final String nacionalidad);
	
	public List<Futbolistas> obtenerFutbolistasPorNifYNombre(final String nif, final String nombre);

	

	

	public void eliminarFutbolistaPorId(final long IdFutbolista);

	public void aniadirFutbolista(final Futbolistas futbolista);

	public void actualizarFutbolista(final Futbolistas futbolista);
}
