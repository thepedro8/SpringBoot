package com.pedro.futbol.repositorios;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Equipo;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Long>{
	Equipo findById(long id);
	
	Equipo findByNombre(String nombre);
	
	List <Equipo> findByAnyoCrea(String anyoCrea);
	
	List <Equipo> findByEstadio(String nom_estadio);
	
	List <Equipo> findByNombreOrEstadio(final String nombre, final String nom_estadio);
	
	List <Equipo> findByAnyoCreaOrEstadio(final String anyoCrea, final String nom_estadio);
	
	List <Equipo> findByNombreAndAnyoCrea(final String nombre, final String anyoCrea);
	List <Equipo> findByAnyoCreaAndEstadio(final String anyoCrea, final String estadio);
	List <Equipo> findByNombreAndEstadio(final String nombre, final String estadio);
	
}
