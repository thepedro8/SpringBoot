package com.pedro.futbol.servicios;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.repositorios.EquipoRepositorio;

/***
 * Clase de servicios para la clase Equipos
 * @author Pedro
 */
@Service
public class EquiposServiceImpl implements EquiposServiceI{

	@Autowired
	private EquipoRepositorio eqrepo;
	
	/***
	 * Método que obtiene todos los equipos
	 */
	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return eqrepo.findAll();
	}

	/***
	 * Método que retorna un objeto de la clase Equipo buscado por su nombre
	 */
	@Override
	public Equipo obtenerEquipoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return eqrepo.findByNombre(nombre);
	}


	/***
	 * Método que obtiene los equipos por el año de creación
	 */
	@Override
	public List<Equipo> obtenerAnyoCreacion(String anyoCrea) {
		// TODO Auto-generated method stub
		return eqrepo.findByAnyoCrea(anyoCrea);
	}

	
	/***
	 * Método que obtiene los equipos por el nombre del estadio
	 */
	@Override
	public List<Equipo> obtenerEstadio(String nom_estadio) {
		// TODO Auto-generated method stub
		return eqrepo.findByEstadio(nom_estadio);
	}

	
	/***
	 * Método que obtiene los equipos por el año de creación y el nombre del estadio
	 */
	@Override
	public List<Equipo> obtenerAnyoCreaYEstadio(String anyoCrea, String estadio) {
		// TODO Auto-generated method stub
		return eqrepo.findByAnyoCreaAndEstadio(anyoCrea, estadio);
	}
	
	
	
	/***
	 * Método que elimina, en la base de datos, al equipo que coincide con la Id introducida.
	 */
	@Override
	public void eliminarEquipoPorId(long IdEquipo) {
		// TODO Auto-generated method stub
		eqrepo.deleteById(IdEquipo);
	}

	
	/***
	 * Método que añade a la base de datos, al equipo que es introducido por el usuario.
	 */
	@Override
	public void aniadirEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		eqrepo.save(equipo);
		
	}

	
	/***
	 * Método que actualiza en la base de datos al equipo introducido.
	 */
	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		eqrepo.save(equipo);
	}

	
	/***
	 * Método que retorna un objeto de la clase Equipo buscado por su Id.
	 */
	@Override
	public Equipo obtenerEquipoPorId(long id) {
		// TODO Auto-generated method stub
		return eqrepo.findById(id);
	}

}
