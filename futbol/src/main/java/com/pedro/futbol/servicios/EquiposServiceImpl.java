package com.pedro.futbol.servicios;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.repositorios.EquipoRepositorio;

@Service
public class EquiposServiceImpl implements EquiposServiceI{

	@Autowired
	private EquipoRepositorio eqrepo;
	
	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return eqrepo.findAll();
	}

	@Override
	public Equipo obtenerEquipoPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return eqrepo.findByNombre(Nombre);
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
		eqrepo.deleteById(IdEquipo);
	}

	@Override
	public void aniadirEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		eqrepo.save(equipo);
		
	}

	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		eqrepo.save(equipo);
	}

}
