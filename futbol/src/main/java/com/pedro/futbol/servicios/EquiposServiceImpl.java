package com.pedro.futbol.servicios;

import java.time.Year;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Equipo;

@Service
public class EquiposServiceImpl implements EquiposServiceI{

	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo obtenerEquipoPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> obtenerNombreYAnyoCrea(String nombre, String anyoCrea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> obtenerAnyoCreacion(String anyoCrea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> obtenerEstadio(String nom_estadio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> obtenerAnyoCreaYEstadio(String anyoCrea, String estadio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> obtenerNombreYEstadio(String nombre, String estadio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> obtenerNombreOEstadio(String nombre, String estadio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Equipo> obtenerAnyoOEstadio(String anyoCrea, String estadio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void eliminarEquipoPorId(long IdEquipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aniadirEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		
	}

}
