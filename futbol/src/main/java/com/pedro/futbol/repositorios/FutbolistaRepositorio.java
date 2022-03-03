package com.pedro.futbol.repositorios;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Futbolistas;

@Repository
public interface FutbolistaRepositorio extends JpaRepository<Futbolistas, Long>{
	Futbolistas findByNombre(String nombre);
	
	Futbolistas findById(long id);
	
	Futbolistas findByNif(String nif);
	
	List <Futbolistas> findByAnyoNac(String anyoNac);
	
	List <Futbolistas> findByNacionalidad(String nacionalidad);
	
	List <Futbolistas> findByNombreAndAnyoNac(final String nombre, final String anyoNac);
	
	List <Futbolistas> findByNombreAndNacionalidad(final String nombre, final String nacionalidad);
	
	List <Futbolistas> findByAnyoNacAndNacionalidad(final String anyoNac, final String nacionalidad);
	
	List <Futbolistas> findByAnyoNacAndNif(final String anyoNac, final String nif);
	
	List <Futbolistas> findByNifAndNacionalidad(final String nif, final String nacionalidad);
	
	
	
	
	List <Futbolistas> findByNifAndNombre(final String nif, final String nombre);
	
	List <Futbolistas> findByNifOrNacionalidadOrAnyoNac(final String nif, final String nacionalidad, final String AnyoNac);

}