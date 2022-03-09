package com.pedro.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Futbolistas;
import com.pedro.futbol.repositorios.EquipoRepositorio;
import com.pedro.futbol.repositorios.FutbolistaRepositorio;

/***
 * Clase de servicios para la clase Futbolistas
 * @author Pedro
 */
@Service
public class FutbolistasServiceImpl implements FutbolistasServiceI{

	@Autowired
	private FutbolistaRepositorio futrepo;
	
	/***
	 * Método implementado que obtiene a todos los futbolistas
	 */
	@Override
	public List<Futbolistas> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return futrepo.findAll();
	}

	
	/***
	 * Método implementado que encuentra al futbolista que coincide con el nombre introducido
	 */
	@Override
	public Futbolistas obtenerFutbolistaPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return futrepo.findByNombre(Nombre);
	}

	
	/***
	 * Método implementado que encuentra al futbolista que coincide con el nif introducido
	 */
	@Override
	public Futbolistas obtenerFutbolistaPorNif(String nif) {
		// TODO Auto-generated method stub
		return futrepo.findByNif(nif);
	}
	
	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con el año de nacimiento introducido
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNac(String anyoNac) {
		// TODO Auto-generated method stub
		return futrepo.findByAnyoNac(anyoNac);
	}

	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con la misma nacionalidad
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByNacionalidad(nacionalidad);
	}
	
	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con el nombre y año de nacimiento
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNombreYAnyoNac(String nombre, String anioNac) {
		// TODO Auto-generated method stub
		return futrepo.findByNombreAndAnyoNac(nombre, anioNac);
	}

	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con el nif y nombre
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifYNombre(String nif, String nombre) {
		// TODO Auto-generated method stub
		return futrepo.findByNifAndNombre(nif, nombre);
	}

	
	/***
	 * Método implementado que elimina a un futbolista de la base de datos
	 */
	@Override
	public void eliminarFutbolistaPorId(long IdFutbolista) {
		// TODO Auto-generated method stub
		futrepo.deleteById(IdFutbolista);
	}

	
	/***
	 * Método implementado que añade un futbolista a la base de datos
	 */
	@Override
	public void aniadirFutbolista(Futbolistas futbolista) {
		futrepo.save(futbolista);
	}

	
	/***
	 * Método implementado que actualiza a un futbolista que se encuentra en la base de datos.
	 */
	@Override
	public void actualizarFutbolista(Futbolistas futbolista) {
		// TODO Auto-generated method stub
		futrepo.save(futbolista);
	}
	
	
	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con el nombre y nacionalidad
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNombreYNacionalidad(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByNombreAndNacionalidad(nombre, nacionalidad);
	}
	

	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el nif y nacionalidad
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorNifYNacion(String nif, String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByNifAndNacionalidad(nif, nacionalidad);
	}


	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con el año de nacimiento y nacionalidad
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNacionalidad(String anyoNac, String nacionalidad) {
		// TODO Auto-generated method stub
		return futrepo.findByAnyoNacAndNacionalidad(anyoNac, nacionalidad);
	}

	
	/***
	 * Método implementado que encuentra a los futbolistas que coinciden con el año de nacimiento y nif
	 */
	@Override
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNif(String anyoNac, String nif) {
		// TODO Auto-generated method stub
		return futrepo.findByAnyoNacAndNif(anyoNac, nif);  
	}

	
	/***
	 * Método implementado que encuentra al futbolista que coincide con la id introducida
	 */
	@Override
	public Futbolistas obtenerFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		return futrepo.findById(id);
	}

	

	



}
