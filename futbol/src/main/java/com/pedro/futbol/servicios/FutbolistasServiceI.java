package com.pedro.futbol.servicios;

import java.util.List;

import com.pedro.futbol.entidades.Futbolistas;


public interface FutbolistasServiceI {
	public List<Futbolistas> obtenerTodosFutbolistas();

	public Futbolistas obtenerFutbolistaPorNombre(final String Nombre);
	
	public List<Futbolistas> obtenerFutbolistasPorAnyoNac(int anyoNac);
	
	public List<Futbolistas> obtenerFutbolistasPorNacionalidad(String nacionalidad);
	
	public List<Futbolistas> obtenerFutbolistasPorNif(int nif);

	public List<Futbolistas> obtenerFutbolistasPorNombreYAnyoNac(final String nombre, final String anioNac);

	public List<Futbolistas> obtenerFutbolistasPorNifYNombre(final String nif, final String nombre);

	public void eliminarFutbolistaPorId(final long IdCoche);

	public void aniadirFutbolista(final Futbolistas futbolista);

	public void actualizarFutbolista(final Futbolistas futbolista);
}
