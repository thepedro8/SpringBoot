package com.pedro.futbol.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.entidades.Futbolista_Equipo;
import com.pedro.futbol.entidades.Futbolistas;
import com.pedro.futbol.modelo.Modelo;
import com.pedro.futbol.servicios.EquiposServiceI;
import com.pedro.futbol.servicios.FutEquiServiceI;
import com.pedro.futbol.servicios.FutbolistasServiceI;


/***
 * Clase controlador para las vistas que interactúan con la clase Futbolista_Equipo
 * @author Pedro
 *
 */
@Controller
public class FutEquiController {
	
	@Autowired
	private FutEquiServiceI futEquiServiceI;
	
	@Autowired
	private EquiposServiceI equipoServiceI;
	
	@Autowired
	private FutbolistasServiceI futbolServiceI;
	
	
	
	private List<Modelo> lista = null;
	
	/***
	 * Método que sirve para mostrar los futbolistas en la lista despegable de la vista.
	 * @param model Representa la vista
	 * @return Retorna la vista de selección de jugador con la lista cargada.
	 */
	@GetMapping("/showHisFutView")
	public String mostrarFutbolistas(Model model) {

		// Obtención de futbolistas
		final List<Futbolistas> listaFutbolista = futEquiServiceI.obtenerTodosFutbolistas();

		// Carga de datos al modelo
		model.addAttribute("futbolistas", listaFutbolista);

		return "showHisFut";
	}
	
	
	
	/***
	 * Método que sirve para mostrar los equipos en la lista despegable de la vista.
	 * @param model Representa la vista
	 * @return Retorna la vista de selección de equipos con la lista cargada.
	 */
	@GetMapping("/showHisEquView")
	public String mostrarEquipos(Model model) {

		// Obtención de equipos
		final List<Equipo> listaEquipo = futEquiServiceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("equipos", listaEquipo);

		return "showHisEqu";
	}
	
	
	
	/***
	 * Método que rellena las listas despegables de la vista con los futbolistas y los equipos
	 * @param model Representa la vista
	 * @return Retorna la vista con las listas cargadas.
	 */
	@GetMapping("/newTrayectoriaView")
	public String mostrarNombres(Model model) {

		// Obtención de futbolistas
		final List<Futbolistas> listaFutbolista = futEquiServiceI.obtenerTodosFutbolistas();

		
		// Obtención de equipos
		final List<Equipo> listaEquipo = futEquiServiceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("equipos", listaEquipo);
		// Carga de datos al modelo
		model.addAttribute("futbolistas", listaFutbolista);

		return "newTrayectoria";
	}
	
	
	/***
	 * Método que añade una nueva tupla a la tabla de Futbolista_equipo de la base de datos.
	 * @param newTrayectoria Objeto que contiene los datos de la nueva tupla.
	 * @param result Resultado de la validacion del objeto
	 * @param model Representa la vista
	 * @return Retorna la pantalla principal una vez terminado.
	 * @throws Exception Controla la introducción de datos correctos y que no se repita una trayectoria en el mismo año.
	 */
	@PostMapping("/actAddTrayectoria")
	private String aniadirTrayectoria(@ModelAttribute Modelo newTrayectoria, BindingResult result, Model model) throws Exception {

		List<Futbolista_Equipo> listaTrayectoria = new ArrayList<Futbolista_Equipo>();
		long idJugador = Long.parseLong(newTrayectoria.getJugador());
		String anyoTemporada = newTrayectoria.getAnyo_temp();
		
		if(!anyoTemporada.isEmpty()) {
			int anyo = Integer.parseInt(anyoTemporada);
			
			if(anyo<=0 || anyo>2999 ) {
				throw new Exception("No se puede introducir un año menor o igual a 0 o mayor a 2999");
			}
		}

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {
			listaTrayectoria = futEquiServiceI.obtenerTrayectoriaFutbolista(idJugador);
			
			boolean existe = false;
			
			for(Futbolista_Equipo fe : listaTrayectoria) {
				if(fe.getFutbolista().getId() == idJugador && fe.getAnyo_temp().equals(anyoTemporada)) {
					existe = true;
				}
			}
			
			if(existe != true) {
			
				Futbolistas f = futbolServiceI.obtenerFutbolistaPorId(Long.parseLong(newTrayectoria.getJugador()));
				Equipo e = equipoServiceI.obtenerEquipoPorId(Long.parseLong(newTrayectoria.getEquipo()));
	
				Futbolista_Equipo fe = new Futbolista_Equipo();
				fe.setFutbolista(f);
				fe.setEquipo(e);
				fe.setAnyo_temp(newTrayectoria.getAnyo_temp());
				
				// Se añade el nueva trayectoria
				futEquiServiceI.aniadirTrayectoria(fe);
				
				return "redirect:index";
				
			} else {
				System.out.println("No se ha añadido el jugador porque ese año ya estaba en un equipo.");
				throw new Exception("No se ha añadido el jugador porque ese año ya estaba en un equipo.");
			}
			
		}
	}
	

	
	/***
	 * Método que busca la trayectoria de un futbolista
	 * @param searchedFutbolista Objeto que contiene la id del jugador a buscar.
	 * @param model Representa la vista
	 * @return Retorna una vista que muestra la trayectoria del futbolista en los distintos equipos.
	 * @throws Exception  Controla que el formato de datos introducidos sean correctos.
	 */
	@PostMapping("/actSearchTrayectoria")
	public String submitBuscarTrayectoriaForm(@ModelAttribute Futbolistas searchedFutbolista, Model model) throws Exception {

		List<Futbolista_Equipo> listaTrayectoria = new ArrayList<Futbolista_Equipo>();
		lista = new ArrayList<Modelo>();
		
		final long idFutbolista = searchedFutbolista.getId();

		Modelo t = null;

		//Comprueba que solo está relleno el campo de nombre. 
		if (StringUtils.hasText(String.valueOf(idFutbolista))) {

			// Búsqueda por nombre
			listaTrayectoria = futEquiServiceI.obtenerTrayectoriaFutbolista(idFutbolista);

			for	(Futbolista_Equipo d : listaTrayectoria) {
				t = new Modelo(d.getEquipo().getNombre(), d.getFutbolista().getNombre(),d.getAnyo_temp());
				 
				lista.add(t);
			}
		}
		// Carga de datos al modelo
		model.addAttribute("equipoListView", lista);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showTrayectoriaFut";

	}
	
	
	
	/***
	 * Método que busca los futbolistas que ha tenido un equipo a lo largo de los años.
	 * @param searchedEquipo Objeto que contiene la id del equipo a buscar.
	 * @param model Representa la vista
	 * @return Retorna una vista que muestra los futbolistas que ha estado en un equipo a lo largo de los años.
	 * @throws Exception Controla que el formato de datos introducidos sean correctos.
	 */
	@PostMapping("/actSearchHistoria")
	public String submitBuscarHistoriaForm(@ModelAttribute Equipo searchedEquipo, Model model) throws Exception {

		List<Futbolista_Equipo> listaHistoria = new ArrayList<Futbolista_Equipo>();
		lista = new ArrayList<Modelo>();

		final long idEquipo = searchedEquipo.getId();

		Modelo t = null;

		//Comprueba que solo está relleno el campo de nombre. 
		if (StringUtils.hasText(String.valueOf(idEquipo))) {

			// Búsqueda por nombre
			listaHistoria = futEquiServiceI.obtenerHistoriaEq(idEquipo);

			for	(Futbolista_Equipo d : listaHistoria) {
				System.out.println(d.getFutbolista().getNombre() + " "+ d.getAnyo_temp());
				t = new Modelo(d.getEquipo().getNombre(), d.getFutbolista().getNombre(),d.getAnyo_temp());
				 
				lista.add(t);
			}
		}
		// Carga de datos al modelo
		model.addAttribute("futsListView", lista);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showHistoriaEq";

	}
	
}
