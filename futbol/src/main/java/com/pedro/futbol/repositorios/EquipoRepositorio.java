package com.pedro.futbol.repositorios;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Equipo;


/***
 * Repositorio donde realizamos acciones con la tabla Equipos de la base de datos.
 * @author Pedro
 */
@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Long>{
	/***
	 * Método que busca a un equipo por su id
	 * @param id Id del equipo
	 * @return Retorna un objeto de la clase Equipo que coincide con la id introducida.
	 */
	Equipo findById(long id);
	
	
	/***
	 * Método que busca a un equipo por su nombre
	 * @param nombre Nombre del equipo 
	 * @return Retorna un objeto de la clase Equipo que coincide con el nombre introducido.
	 */
	Equipo findByNombre(String nombre);
	
	
	/***
	 * Método que busca a los equipos que coinciden con el año de creación.
	 * @param anyoCrea Año de creación de los equipos.
	 * @return Retorna una lista con los equipos que coinciden con su año de creación.
	 */
	List <Equipo> findByAnyoCrea(String anyoCrea);
	
	
	/***
	 * Método que busca a los equipos que coinciden con el nombre de su estadio.
	 * @param nom_estadio Nombre del estadio
	 * @return Retorna una lista con los equipos que coinciden con el nombre de su estadio
	 */
	List <Equipo> findByEstadio(String nom_estadio);
	
	
	/***
	 * Método que busca a los equipos que coinciden con su año de creación y el nombre de su estadio
	 * @param anyoCrea Año de creación
	 * @param estadio Nombre del estadio
	 * @return Retorna un listado con los equipos que coinciden con su año de creación y el nombre de su estadio.
	 */
	List <Equipo> findByAnyoCreaAndEstadio(final String anyoCrea, final String estadio);
	
	
}
