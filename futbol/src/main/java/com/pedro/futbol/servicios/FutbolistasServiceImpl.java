package com.pedro.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Futbolistas;
import com.pedro.futbol.repositorios.EquipoRepositorio;
import com.pedro.futbol.repositorios.FutbolistaRepositorio;

@Service
public class FutbolistasServiceImpl implements FutbolistasServiceI{

	@Autowired
	private FutbolistaRepositorio futrepo;
	
	@Override
	public List<Futbolistas> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return futrepo.findAll();
	}

	@Override
	public Futbolistas obtenerFutbolistaPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return futrepo.findByNombre(Nombre);
	}

	@Override
	public Futbolistas obtenerFutbolistaPorNif(String nif) {
		// TODO Auto-generated method stub
		return futrepo.findByNif(nif);
	}
	
	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNac(String anyoNac) {
		// TODO Auto-generated method stub
		return futrepo.findByAnyoNac(anyoNac);
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByNacionalidad(nacionalidad);
	}
	
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNombreYAnyoNac(String nombre, String anioNac) {
		// TODO Auto-generated method stub
		return futrepo.findByNombreAndAnyoNac(nombre, anioNac);
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifYNombre(String nif, String nombre) {
		// TODO Auto-generated method stub
		return futrepo.findByNifAndNombre(nif, nombre);
	}

	@Override
	public void eliminarFutbolistaPorId(long IdFutbolista) {
		// TODO Auto-generated method stub
		futrepo.deleteById(IdFutbolista);
	}

	@Override
	public void aniadirFutbolista(Futbolistas futbolista) {
		futrepo.save(futbolista);
	}

	@Override
	public void actualizarFutbolista(Futbolistas futbolista) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNombreYNacionalidad(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByNombreAndNacionalidad(nombre, nacionalidad);
	}
	

	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifYNacion(String nif, String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByNifAndNacionalidad(nif, nacionalidad);
	}

	//@Override
	//public List<Futbolistas> obtenerFutbolistasPorNifONacionalidadOAnyoNac(String nif, String nacionalidad, String anyoNac) {
		// TODO Auto-generated method stub
		//return futrepo.findByNifOrNacionalidadOrAnyoNac(nif, nacionalidad, anyoNac);
	//}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNacionalidad(String anyoNac, String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByAnyoNacAndNacionalidad(anyoNac, nacionalidad);
	}

	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNif(String anyoNac, String nif) {
		// TODO Auto-generated method stub
		return futrepo.findByAnyoNacAndNif(anyoNac, nif);  
	}

	@Override
	public Futbolistas obtenerFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		return futrepo.findById(id);
	}

	

	



}
