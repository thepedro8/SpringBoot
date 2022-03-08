package com.pedro.futbol.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.pedro.futbol.servicios.EquiposServiceI;


@Controller
public class EquipoController {
	@Autowired
	private EquiposServiceI equipoServiceI;
	

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}
	
	@GetMapping("/showEquiposView")
	public String mostrarEquipos(Model model) {

		// Obtención de equipo
		final List<Equipo> listaEquipos = equipoServiceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("equipoListView", listaEquipos);
		model.addAttribute("btnDropEquipoEnabled", Boolean.FALSE);

		return "showEquipos";
	}

	@PostMapping("/actDropEquipo")
	public String eliminarEquipo(@RequestParam String equId, Model model) {

		// Eliminación de equipo
		equipoServiceI.eliminarEquipoPorId(Long.valueOf(equId));

		return "redirect:showEquiposView";

	}
	
	
	@PostMapping("/actSearchEquipo")
	public String submitBuscarEquipoForm(@ModelAttribute Equipo searchedEquipo, Model model) throws Exception {

		List<Equipo> listaEquipos = new ArrayList<Equipo>();

		final String nomEquipo = searchedEquipo.getNombre();
		final String anyoCreacion = searchedEquipo.getAnyoCrea();
		final String nomEstadio = searchedEquipo.getEstadio();

		if(!anyoCreacion.isEmpty()) {
			int anyo = Integer.parseInt(anyoCreacion);
			
			if(anyo<=0 || anyo>2999 ) {
				throw new Exception("No se puede introducir un año menor o igual a 0 o mayor a 2999");
			}
		}
		
			if (StringUtils.hasText(nomEquipo)) {
	
				// Búsqueda por nombre
				final Equipo equipo = equipoServiceI.obtenerEquipoPorNombre(nomEquipo);
	
				if (equipo != null) {
					listaEquipos.add(equipo);
					System.out.println(listaEquipos.size());
				}
			} else if (!StringUtils.hasText(nomEquipo)
					&& (StringUtils.hasText(anyoCreacion) && !StringUtils.hasText(nomEstadio))) {
	
				listaEquipos = equipoServiceI.obtenerAnyoCreacion(anyoCreacion);
	
			} else if (!StringUtils.hasText(nomEquipo)
					&& (!StringUtils.hasText(anyoCreacion) && StringUtils.hasText(nomEstadio))) {
	
				listaEquipos = equipoServiceI.obtenerEstadio(nomEstadio);
	
			}else if (!StringUtils.hasText(nomEquipo)
					&& (StringUtils.hasText(anyoCreacion) && StringUtils.hasText(nomEstadio))) {
	
				listaEquipos = equipoServiceI.obtenerAnyoCreaYEstadio(anyoCreacion, nomEstadio);
			} else {
				throw new Exception("Parámetros de búsqueda erróneos.");
			}
	
			// Carga de datos al modelo
			model.addAttribute("equipoListView", listaEquipos);
			model.addAttribute("btnDropEquipoEnabled", Boolean.FALSE);
	
			return "showEquipos";
		

	}
	
	
	
	@PostMapping("/actAddEquipo")
	private String aniadirEquipo(@ModelAttribute Equipo newEquipo, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {
			
			int anyo = Integer.parseInt(newEquipo.getAnyoCrea());
			
			if(anyo<=0 || anyo>2999 ) {
				throw new Exception("No se puede introducir un año menor o igual a 0 o mayor a 2999");
			} else {
				// Se añade el nuevo equipo
				equipoServiceI.aniadirEquipo(newEquipo);
			}
		}

		return "redirect:showEquiposView";
	}
	
	
	
	 @GetMapping("/editEquipoView")
		public String recogerEquipo(String equipoId, Model model) {

			// Obtención de equipos

		  	long idEquipo = Long.valueOf(equipoId);
		  
			Equipo p = equipoServiceI.obtenerEquipoPorId(Long.valueOf(equipoId));

			// Carga de datos al modelo
			model.addAttribute("id", p.getId());
			model.addAttribute("nombre", p.getNombre());
			model.addAttribute("estadio", p.getEstadio());
			model.addAttribute("anyoCrea", p.getAnyoCrea());

			return "editEquipo";
		}
	 
	 
	
	@PostMapping("/actEditEquipo")
	public String editarEquipo(@ModelAttribute Equipo editEquipo, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {
			
			Equipo e = equipoServiceI.obtenerEquipoPorId(editEquipo.getId());

			e.setNombre(editEquipo.getNombre());
			e.setEstadio(editEquipo.getEstadio());
			e.setAnyoCrea(editEquipo.getAnyoCrea());
			
			int anyo = Integer.parseInt(editEquipo.getAnyoCrea());

			if(anyo<=0 || anyo>2999 ) {
				throw new Exception("No se puede introducir un año menor o igual a 0 o mayor a 2999");
			} else {
				e.setAnyoCrea(editEquipo.getAnyoCrea());
			}

			equipoServiceI.actualizarEquipo(e);
		}

		return "redirect:showEquiposView";
	}
}
