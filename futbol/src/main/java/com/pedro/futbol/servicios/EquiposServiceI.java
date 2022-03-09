package com.pedro.futbol.servicios;

import java.time.Year;
import java.util.List;

import com.pedro.futbol.entidades.Equipo;

/***
 * Interfaz donde definimos los métodos que implementaran a los servicios de la clase Equipos
 * @author Pedro
 */
public interface EquiposServiceI {
	/***
	 * Método que obtiene todos los equipos
	 * @return Retorna una lista con todos los equipos encontrados en la base de datos
	 */
	public List<Equipo> obtenerTodosEquipos();

	/***
	 * Método que retorna un objeto de la clase Equipo buscado por su nombre
	 * @param Nombre Nombre del equipo
	 * @return Retorna un objeto de la clase Equipo que coincide con el nombre introducido.
	 */
	public Equipo obtenerEquipoPorNombre(final String Nombre);
	
	
	/***
	 * Método que retorna un objeto de la clase Equipo buscado por su Id.
	 * @param id Id del equipo
	 * @return Retorna un objeto de la clase Equipo que coincide con la id introducida.
	 */
	public Equipo obtenerEquipoPorId(final long id);
	
	
	/***
	 * Método que obtiene los equipos por el año de creación
	 * @param anyoCrea Año de creación del equipo
	 * @return Retorna una lista con los equipos que coinciden con el año de creación
	 */
	public List<Equipo> obtenerAnyoCreacion(String anyoCrea);

	
	/***
	 * Método que obtiene los equipos por el nombre del estadio
	 * @param nom_estadio Nombre del estadio
	 * @return Retorna una lista con los equipos que coinciden con el nombre de su estadio.
	 */
	public List<Equipo> obtenerEstadio(String nom_estadio);

	
	/***
	 * Método que obtiene los equipos por el año de creación y el nombre del estadio
	 * @param anyoCrea Año de creación del equipo
	 * @param estadio Nombre del estadio
	 * @return Retorna una list con los equipos que coinciden con el año de creación y el nombre del estadio
	 */
	public List<Equipo> obtenerAnyoCreaYEstadio(final String anyoCrea, final String estadio);
	
	
	/***
	 * Método que elimina, en la base de datos, al equipo que coincide con la Id introducida.
	 * @param IdEquipo Id del equipo a eliminar
	 */
	public void eliminarEquipoPorId(final long IdEquipo);

	/***
	 * Método que añade a la base de datos, al equipo que es introducido por el usuario.
	 * @param equipo Objeto de la clase Equipo que vamos a añadir
	 */
	public void aniadirEquipo(final Equipo equipo);

	
	/***
	 * Método que actualiza en la base de datos al equipo introducido.
	 * @param equipo Objeto de la clase Equipo que vamos a actualizar.
	 */
	public void actualizarEquipo(final Equipo equipo);
}
