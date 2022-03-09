package com.pedro.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;
import com.pedro.futbol.repositorios.EquipoRepositorio;
import com.pedro.futbol.repositorios.FutEquiRepositorio;
import com.pedro.futbol.repositorios.FutbolistaRepositorio;

/***
 * Clase de servicios para la clase Futbolistas_Equipo
 * @author Pedro
 */
@Service
public class FutEquiServiceImpl implements FutEquiServiceI{

	@Autowired
	private FutbolistaRepositorio futbolistarepo;
	
	@Autowired
	private EquipoRepositorio equiporepo;
	
	@Autowired
	private FutEquiRepositorio futEquirepo;
	
	
	/***
	 * Método que obtiene todos los futbolistas de la base de datos
	 */
	@Override
	public List<Futbolistas> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return futbolistarepo.findAll();
	}

	
	/***
	 * Método que retorna la trayectoria del futbolista introducido
	 */
	@Override
	public List<Futbolista_Equipo> obtenerTrayectoriaFutbolista(long id) {
		// TODO Auto-generated method stub
		return futEquirepo.findByFutbolista(id);
	}

	
	
	/***
	 * Método que obtiene todos los equipos de la base de datos
	 */
	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return equiporepo.findAll();
	}
	
	
	/***
	 * Método que obtiene a los futbolistas de los equipos 
	 */
	@Override
	public List<Futbolista_Equipo> obtenerHistoriaEq(long idEquipo) {
		// TODO Auto-generated method stub
		return futEquirepo.findByEquipo(idEquipo);
	}

	
	/***
	 * Método que añade una tupla a la tabla de Futbolistas_Equipo en la base de datos
	 */
	@Override
	public void aniadirTrayectoria(Futbolista_Equipo futEqui) {
		// TODO Auto-generated method stub
		futEquirepo.save(futEqui);
	}

}
