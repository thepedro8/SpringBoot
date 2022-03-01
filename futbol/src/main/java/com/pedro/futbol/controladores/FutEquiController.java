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
import com.pedro.futbol.servicios.EquiposServiceI;
import com.pedro.futbol.servicios.FutEquiServiceI;
import com.pedro.futbol.servicios.FutbolistasServiceI;

@Controller
public class FutEquiController {
	
	@Autowired
	private FutEquiServiceI futEquiServiceI;
	
	@Autowired
	private EquiposServiceI equipoServiceI;
	
	private List<Equipo> listaEquipos = null;
	
	
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

//	@PostMapping("/actDropFutbolista")
//	public String eliminarFutbolista(@RequestParam String futId, Model model) {
//
//		// Eliminación de futbolista
//		futbolistaServiceI.eliminarFutbolistaPorId(Long.valueOf(futId));
//
//		return "redirect:showFutbolistasView";
//
//	}
//	
//	
//	@PostMapping("/actAddFutbolista")
//	private String aniadirFutbolista(@ModelAttribute Futbolistas newFutbolista, BindingResult result) throws Exception {
//
//		if (result.hasErrors()) {
//			throw new Exception("Parámetros de matriculación erróneos");
//		} else {
//
//			// Se añade el nuevo coche
//			futbolistaServiceI.aniadirFutbolista(newFutbolista);
//		}
//
//		return "redirect:showFutbolistasView";
//	}
//	

	@PostMapping("/actSearchTrayectoria")
	public String submitBuscarTrayectoriaForm(@ModelAttribute Futbolistas searchedFutbolista, Model model) throws Exception {

		List<Futbolista_Equipo> listaTrayectoria = new ArrayList<Futbolista_Equipo>();
		listaEquipos = new ArrayList<Equipo>();
		
		System.out.println(searchedFutbolista);

		final long idFutbolista = searchedFutbolista.getId();
		
		String anyo  = "";

		Equipo e = null;

		System.out.println(idFutbolista);
		//Comprueba que solo está relleno el campo de nombre. 
		if (StringUtils.hasText(String.valueOf(idFutbolista))) {

			// Búsqueda por nombre
			listaTrayectoria = futEquiServiceI.obtenerTrayectoriaFutbolista(idFutbolista);

			//System.out.println(listaTrayectoria.size());
			
			for	(Futbolista_Equipo d : listaTrayectoria) {
				System.out.println(d.getId() + " " + d.getAnyo_temp());
				
				 e = d.getEquipo();
				 e.setAnyoCrea(d.getAnyo_temp());
				 
				anyo = d.getAnyo_temp();
				 
				 System.out.println("El equipo sacado de la lista es: " + e.getNombre());
					listaEquipos.add(e);
				
			}
			
			
		}
		// Carga de datos al modelo
		model.addAttribute("equipoListView", listaEquipos);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showEquipos";

	}
	
}
