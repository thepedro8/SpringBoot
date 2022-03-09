package com.pedro.futbol.servicios;

import java.util.List;

import com.pedro.futbol.entidades.Futbolistas;

/***
 * Interfaz donde definimos los métodos que implementaran a los servicios de la clase Futbolistas
 * @author Pedro
 */
public interface FutbolistasServiceI {
	/***
	 * Método que obtiene a todos los futbolistas
	 * @return Retorna una lista con todos los futbolistas de la base de datos
	 */
	public List<Futbolistas> obtenerTodosFutbolistas();
	
	
	/***
	 * Método que encuentra al futbolista que coincide con la id introducida
	 * @param id Id del futbolista
	 * @return Retorna un objeto de la clase Futbolistas.
	 */
	public Futbolistas obtenerFutbolistaPorId(final long id);
	
	/***
	 * Método que encuentra al futbolista que coincide con el nombre introducido
	 * @param Nombre Nombre del futbolista
	 * @return Retorna un objeto de la clase Futbolistas
	 */
	public Futbolistas obtenerFutbolistaPorNombre(final String Nombre);
	
	/***
	 * Método que encuentra al futbolista que coincide con el nif introducido
	 * @param Nif Nif del futbolista
	 * @return Retorna un objeto de la clase Futbolistas
	 */
	public Futbolistas obtenerFutbolistaPorNif(final String Nif);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el año de nacimiento introducido
	 * @param anyoNac Año de nacimiento del futbolista
	 * @return	Retorna una lista con los futbolistas que nacieron en el año introducido
	 */
	public List<Futbolistas> obtenerFutbolistasPorAnyoNac(final String anyoNac);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con la misma nacionalidad
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que son de la misma nacionalidad
	 */
	public List<Futbolistas> obtenerFutbolistasPorNacionalidad(final String nacionalidad);

	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el nombre y año de nacimiento
	 * @param nombre Nombre del futbolista
	 * @param anyoNac Año de nacimientos del futbolista
	 * @return Retorna una lista con los futbolistas que tienen el mismo nombre y el mismo año de nacimiento
	 */
	public List<Futbolistas> obtenerFutbolistasPorNombreYAnyoNac(final String nombre, final String anyoNac);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el nombre y nacionalidad
	 * @param nombre Nombre del futbolista
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que tienen el mismo nombre y la misma nacionalidad
	 */
	public List<Futbolistas> obtenerFutbolistasPorNombreYNacionalidad(final String nombre, final String nacionalidad);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el año de nacimiento y nacionalidad
	 * @param anyoNac Año de nacimiento del futbolista
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que tienen el mismo año de nacimiento y nacionalidad
	 */
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNacionalidad(final String anyoNac, final String nacionalidad);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el año de nacimiento y nif
	 * @param anyoNac Año de nacimiento del futbolista 
	 * @param nif Nif del futbolista
	 * @return Retorna una lista con los futbolistas que tienen el mismo año de nacimiento y nif
	 */
	public List<Futbolistas> obtenerFutbolistasPorAnyoNacYNif(final String anyoNac, final String nif);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el nif y nacionalidad
	 * @param nif Nif del futbolista
	 * @param nacionalidad Nacionalidad del futbolista
	 * @return Retorna una lista con los futbolistas que tienen el mismo nif y nacionalidad
	 */
	public List<Futbolistas> obtenerFutbolistasPorNifYNacion(final String nif, final String nacionalidad);
	
	
	/***
	 * Método que encuentra a los futbolistas que coinciden con el nif y nombre
	 * @param nif Nif del futbolista
	 * @param nombre Nombre del futbolista
	 * @return Retorna una lista con los futbolistas que tienen el mismo nif y nombre
	 */
	public List<Futbolistas> obtenerFutbolistasPorNifYNombre(final String nif, final String nombre);

	

	/***
	 * Método que elimina a un futbolista de la base de datos
	 * @param IdFutbolista Id del futbolista a eliminar
	 */

	public void eliminarFutbolistaPorId(final long IdFutbolista);

	
	/***
	 * Método que añade un futbolista a la base de datos
	 * @param futbolista Objeto de la clase Futbolistas que añadimos a la base de datos
	 */
	public void aniadirFutbolista(final Futbolistas futbolista);

	
	/***
	 * Método que actualiza a un futbolista que se encuentra en la base de datos.
	 * @param futbolista Objeto de la clase Futbolistas que actualizamos en la base de datos
	 */
	public void actualizarFutbolista(final Futbolistas futbolista);
}
