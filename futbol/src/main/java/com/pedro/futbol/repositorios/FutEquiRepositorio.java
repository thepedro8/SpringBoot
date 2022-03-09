package com.pedro.futbol.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;

/***
 * Repositorio donde realizamos acciones con la tabla Futbolistas_Equipo de la base de datos.
 * @author Pedro
 */
@Repository
public interface FutEquiRepositorio extends JpaRepository<Futbolista_Equipo, Long>{

	/***
	 * Método que busca las tuplas con las ids de futbolistas que concuerdan con la introducida
	 * @param futbolista Id del futbolista
	 * @return Retorna una lista con las tuplas que contengan la id del futbolista
	 */
	@Query(value = "SELECT * FROM Futbolista_Equipo WHERE futbolista_id = ?", nativeQuery = true)
	List <Futbolista_Equipo> findByFutbolista(long futbolista);
	
	
	/***
	 * Método que busca las tuplas con las ids de equipos que concuerdan con la introducida
	 * @param idEquipo Id del futbolista
	 * @return Retorna una lista con las tuplas que contengan la id del equipo
	 */
	@Query(value = "SELECT * FROM Futbolista_Equipo WHERE equipo_id = ?", nativeQuery = true)
	List <Futbolista_Equipo> findByEquipo(long idEquipo);
}