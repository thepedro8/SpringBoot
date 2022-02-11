package com.pedro.futbol.repositorios;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Futbolistas;

@Repository
public interface FutbolistaRepositorio extends JpaRepository<Futbolistas, Long>{
	List <Futbolistas> findByNombre(String nombre);
	
	List <Futbolistas> findByAnyoNac(int anyoNac);
	
	List <Futbolistas> findByNacionalidad(String nacionalidad);
	
	List <Futbolistas> findByNif(int nif);
	
	List <Futbolistas> findByNombreAndAnyoNac(final String nombre, final Year anyoNac);
	List <Futbolistas> findByAnyoNacAndNacionalidad(final Year anyoNac, final String nacionalidad);
	List <Futbolistas> findByNifAndNombre(final String nif, final String nombre);
}