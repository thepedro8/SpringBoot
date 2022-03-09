package com.pedro.futbol.servicios;

import java.util.List;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;

/***
 * Interfaz donde definimos los métodos que implementaran a los servicios de la clase Futbolistas_Equipos
 * @author Pedro
 */
public interface FutEquiServiceI {
	
	/***
	 * Método que obtiene todos los futbolistas de la base de datos
	 * @return Retorna una lista con todos los futbolistas
	 */
	public List<Futbolistas> obtenerTodosFutbolistas();
	
	/***
	 * Método que obtiene todos los equipos de la base de datos
	 * @return Retorna una lista con todos los equipos
	 */
	public List<Equipo> obtenerTodosEquipos();
	
	
	/***
	 * Método que obtiene las tuplas de la tabla Futbolista_Equipo que coincide con la id del futbolista
	 * @param futbolista Id del futbolista
	 * @return Retorna una lista con las tuplas de la tabla Futbolista_Equipo que coincide con la id del futbolista
	 */
	public List<Futbolista_Equipo> obtenerTrayectoriaFutbolista(final long futbolista);
	
	
	/***
	 * Método que obtiene las tuplas de la tabla Futbolista_Equipo que coincide con la id del equipo
	 * @param idEquipo Id del equipo
	 * @return Retorna una lista con las tuplas de la tabla Futbolista_Equipo que coincide con la id del equipo
	 */
	public List<Futbolista_Equipo> obtenerHistoriaEq(final long idEquipo);
	
	/***
	 * Método que sirve para añadir una nueva tupla en la tabla Futbolista_Equipo en la base de datos.
	 * @param futEqui Objeto de la clase Futbolista_Equipo que vamos a añadir a la base de datos.
	 */
	public void aniadirTrayectoria(final Futbolista_Equipo futEqui);
}
