package com.pedro.futbol.repositorios;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.futbol.entidades.Futbolistas;

/***
 * Repositorio donde realizamos acciones con la tabla Futbolistas de la base de datos.
 * @author Pedro
 */
@Repository
public interface FutbolistaRepositorio extends JpaRepository<Futbolistas, Long>{
	/***
	 * Método que busca a futbolistas por el nombre
	 * @param nombre Nombre del futbolista
	 * @return Retorna un objeto de la clase Futbolista que coincide con el nombre introducido.
	 */
	Futbolistas findByNombre(String nombre);
	
	
	/***
	 * Método que busca a un futbolista por su id.
	 * @param id Id del futbolista
	 * @return Retorna un objeto de la clase Futbolista que coincide con el id introducido
	 */
	Futbolistas findById(long id);
	
	
	/***
	 * Método que busca a un futbolista por su nif
	 * @param nif Nif del futbolista
	 * @return Retorna un objeto de la clase Futbolista que coincide con el nif introducido
	 */
	Futbolistas findByNif(String nif);
	
	
	/***
	 * Método que busca a los futbolistas que comparten año de nacimiento
	 * @param anyoNac Año de nacimiento del futbolista
	 * @return Retorna una lista con los futbolistas que nacieron el mismo año
	 */
	List <Futbolistas> findByAnyoNac(String anyoNac);
	
	
	/***
	 * Método que busca a los futbolistas que comparten nacionalidad
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que comparten la nacionalidad
	 */
	List <Futbolistas> findByNacionalidad(String nacionalidad);
	
	/***
	 * Método que busca a los futbolistas que comparte nombre y año de nacimiento
	 * @param nombre Nombre de futbolista
	 * @param anyoNac Año de nacimiento del futbolista
	 * @return Retorna una lista con los futbolistas que comparten nombre y año de nacimiento
	 */
	List <Futbolistas> findByNombreAndAnyoNac(final String nombre, final String anyoNac);
	
	
	/***
	 * Método que busca a los futbolistas que comparten nombre y nacionalidad
	 * @param nombre Nombre del futbolista
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que comparten nombre y nacionalidad
	 */
	List <Futbolistas> findByNombreAndNacionalidad(final String nombre, final String nacionalidad);
	
	
	/***
	 * Método que busca a los futbolistas que comparten año de nacimiento y nacionalidad
	 * @param anyoNac Año de nacimiento del futbolista
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que comparten año de nacimiento y nacionalidad
	 */
	List <Futbolistas> findByAnyoNacAndNacionalidad(final String anyoNac, final String nacionalidad);
	
	
	/***
	 * Método que busca a los futbolistas que comparten año de nacimiento y nif
	 * @param anyoNac Año de nacimiento del futbolista
	 * @param nif Nif del futbolista
	 * @return Retorna una lista con los futbolistas que comparten año de nacimiento y nif
	 */
	List <Futbolistas> findByAnyoNacAndNif(final String anyoNac, final String nif);
	
	
	/***
	 * Método que busca a los futbolistas que comparten año de nif y nacionalidad
	 * @param nif Nif del futbolista
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que comparten nif y nacionalidad
	 */
	List <Futbolistas> findByNifAndNacionalidad(final String nif, final String nacionalidad);
	
	
	/***
	 * Mñetodo que busca a los futbolistas que comparten nif y nombre
	 * @param nif Nif del futbolista
	 * @param nombre Nombre del futbolista
	 * @return Retorna una lista con los futbolistas que comparten nif y nombre.
	 */
	List <Futbolistas> findByNifAndNombre(final String nif, final String nombre);
	


}