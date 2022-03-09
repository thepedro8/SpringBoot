package com.pedro.futbol.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * Controlador de redirecciones.
 * @author Pedro
 *
 */
@Controller
@RequestMapping("*")
public class SystemController {
	
	/***
	 * Método que redirige a la vista principal.
	 * @return Retorna la vista "index"
	 */
	//Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	/***
	 * Método que redirige a la vista donde vemos el listado de equipos
	 * @return Retorna la vista "showEquipos"
	 */
	//Redirecciona al controlador de gestión de coches
	@GetMapping("/EquiposView")
	public String redirectToEquipoDealershipController() {
		return "redirect:showEquipos";
	}
	
	/***
	 * Método que redirige a la vista donde buscamos a los equipos
	 * @return Retorna la vista "searchEquipoBy"
	 */
	//Redirecciona a la plantilla de búsqueda
	@GetMapping("/searchEquipoByView")
	public String redirectToEquipoSearchByTemplate() {
		return "searchEquipoBy";
	}
	
	
	/***
	 * Método que redirige a la vista donde añadimos un equipo
	 * @return Retorna la vista "newEquipo"
	 */
	//Redirecciona a la plantilla de insercción
	@GetMapping("/newEquipoView")
	public String redirectToNewEquipoTemplate() {
		return "newEquipo";
	}
	
	/***
	 * Método que redirige a la vista donde añadimos un futbolista
	 * @return Retorna la vista "newFutbolista"
	 */
	//Redirecciona a la plantilla de insercción
	@GetMapping("/newFutbolistaView")
	public String redirectToNewFutbolistaTemplate() {
		return "newFutbolista";
	}
	
	
	/***
	 * Método que redirige a la vista donde buscamos a los futbolistas
	 * @return Retorna la vista "searchFutbolistaBy"
	 */
	//Redirecciona a la plantilla de búsqueda
	@GetMapping("/searchFutbolistaByView")
	public String redirectToFutbolistaSearchByTemplate() {
		return "searchFutbolistaBy";
	}
	
	
}
