package com.pedro.futbol.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {
	
	
	//Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	//Redirecciona al controlador de gestión de coches
	@GetMapping("/EquiposView")
	public String redirectToEquipoDealershipController() {
		return "redirect:showEquipos";
	}
	
	//Redirecciona a la plantilla de búsqueda
	@GetMapping("/searchEquipoByView")
	public String redirectToEquipoSearchByTemplate() {
		return "searchEquipoBy";
	}
	
	//Redirecciona a la plantilla de insercción
	@GetMapping("/newEquipoView")
	public String redirectToNewEquipoTemplate() {
		return "newEquipo";
	}

}
