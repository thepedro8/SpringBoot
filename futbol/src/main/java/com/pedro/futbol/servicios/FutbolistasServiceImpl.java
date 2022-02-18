package com.pedro.futbol.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Futbolistas;

@Service
public class FutbolistasServiceImpl implements FutbolistasServiceI{

	@Override
	public List<Futbolistas> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Futbolistas obtenerFutbolistaPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNombreYAnyoNac(String nombre, String anioNac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifYNombre(String nif, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarFutbolistaPorId(long IdCoche) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aniadirFutbolista(Futbolistas futbolista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarFutbolista(Futbolistas futbolista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNac(int anyoNac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNif(int nif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifYNacion(String nif, String nacionalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifONacion(String nif, String nacionalidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
