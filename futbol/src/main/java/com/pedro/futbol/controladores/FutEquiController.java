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

@Controller
public class FutEquiController {
	
	@Autowired
	private FutEquiServiceI futEquiServiceI;
	
	@Autowired
	private EquiposServiceI equipoServiceI;
	
	@Autowired
	private FutbolistasServiceI futbolServiceI;
	
	
	
	private List<Modelo> lista = null;
	
	
	@GetMapping("/showHisFutView")
	public String mostrarFutbolistas(Model model) {

		// Obtención de futbolistas
		final List<Futbolistas> listaFutbolista = futEquiServiceI.obtenerTodosFutbolistas();
		//System.out.println(listaFutbolista.size());
		//for	(Futbolistas d : listaFutbolista) {
			//System.out.println(d.getId());
		//}

		// Carga de datos al modelo
		model.addAttribute("futbolistas", listaFutbolista);

		return "showHisFut";
	}
	
	
	
	
	@GetMapping("/showHisEquView")
	public String mostrarEquipos(Model model) {

		// Obtención de equipos
		final List<Equipo> listaEquipo = futEquiServiceI.obtenerTodosEquipos();
		System.out.println(listaEquipo.size());
		for	(Equipo d : listaEquipo) {
			System.out.println(d.getId() + " " + d.getNombre());
		}

		// Carga de datos al modelo
		model.addAttribute("equipos", listaEquipo);

		return "showHisEqu";
	}
	
	
	@GetMapping("/newTrayectoriaView")
	public String mostrarNombres(Model model) {

		// Obtención de futbolistas
		final List<Futbolistas> listaFutbolista = futEquiServiceI.obtenerTodosFutbolistas();
		//System.out.println(listaFutbolista.size());
		//for	(Futbolistas d : listaFutbolista) {
			//System.out.println(d.getId());
		//}
		
		// Obtención de equipos
		final List<Equipo> listaEquipo = futEquiServiceI.obtenerTodosEquipos();
		System.out.println(listaEquipo.size());
		for	(Equipo d : listaEquipo) {
			System.out.println(d.getId() + " " + d.getNombre());
		}

		// Carga de datos al modelo
		model.addAttribute("equipos", listaEquipo);
		// Carga de datos al modelo
		model.addAttribute("futbolistas", listaFutbolista);

		return "newTrayectoria";
	}
	
	

	@PostMapping("/actAddTrayectoria")
	private String aniadirTrayectoria(@ModelAttribute Modelo newTrayectoria, BindingResult result, Model model) throws Exception {

		List<Futbolista_Equipo> listaTrayectoria = new ArrayList<Futbolista_Equipo>();
		long idJugador = Long.parseLong(newTrayectoria.getJugador());
		String anyoTemporada = newTrayectoria.getAnyo_temp();
		
		
		System.out.print(newTrayectoria.toString());
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

				return "redirect:error";
			}
			
		}
	}
//	

	@PostMapping("/actSearchTrayectoria")
	public String submitBuscarTrayectoriaForm(@ModelAttribute Futbolistas searchedFutbolista, Model model) throws Exception {

		List<Futbolista_Equipo> listaTrayectoria = new ArrayList<Futbolista_Equipo>();
		lista = new ArrayList<Modelo>();
		
		System.out.println(searchedFutbolista);

		final long idFutbolista = searchedFutbolista.getId();
		
		String anyo  = "";

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
	
	
	
	@PostMapping("/actSearchHistoria")
	public String submitBuscarHistoriaForm(@ModelAttribute Equipo searchedEquipo, Model model) throws Exception {

		List<Futbolista_Equipo> listaHistoria = new ArrayList<Futbolista_Equipo>();
		lista = new ArrayList<Modelo>();
		
		System.out.println(searchedEquipo);

		final long idEquipo = searchedEquipo.getId();
		
		String anyo  = "";

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
