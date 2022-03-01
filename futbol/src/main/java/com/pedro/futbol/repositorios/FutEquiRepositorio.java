package com.pedro.futbol.repositorios;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;

@Repository
public interface FutEquiRepositorio extends JpaRepository<Futbolista_Equipo, Long>{

	@Query(value = "SELECT * FROM Futbolista_Equipo WHERE futbolista_id = ?", nativeQuery = true)
	List <Futbolista_Equipo> findByFutbolista(long futbolista);
}