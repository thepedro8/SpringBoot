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
import com.pedro.futbol.entidades.Futbolistas;
import com.pedro.futbol.servicios.FutbolistasServiceI;

@Controller
public class FutbolistaController {
	
	@Autowired
	private FutbolistasServiceI futbolistaServiceI;
	
	
	@GetMapping("/showFutbolistasView")
	public String mostrarFutbolistas(Model model) {

		// Obtención de futbolistas
		final List<Futbolistas> listaFutbolista = futbolistaServiceI.obtenerTodosFutbolistas();

		// Carga de datos al modelo
		model.addAttribute("futbolistaListView", listaFutbolista);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showFutbolistas";
	}

	@PostMapping("/actDropFutbolista")
	public String eliminarFutbolista(@RequestParam long futId, Model model) {

		// Eliminación de futbolista
		futbolistaServiceI.eliminarFutbolistaPorId(futId);

		return "redirect:showFutbolistasView";

	}
	
	
	@PostMapping("/actAddFutbolista")
	private String aniadirFutbolista(@ModelAttribute Futbolistas newFutbolista, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			futbolistaServiceI.aniadirFutbolista(newFutbolista);
		}

		return "redirect:showFutbolistasView";
	}
	

	@PostMapping("/actSearchFutbolista")
	public String submitBuscarFutbolistaForm(@ModelAttribute Futbolistas searchedFutbolista, Model model) throws Exception {

		List<Futbolistas> listaFutbolistas = new ArrayList<Futbolistas>();
		Futbolistas futbolista = null;
		
		System.out.println(searchedFutbolista.getNombre());

		final String nomFutbolista = searchedFutbolista.getNombre();
		final String nacFutbolista = searchedFutbolista.getNacionalidad();
		final String fecNac = searchedFutbolista.getAnyoNac();
		final String nifFutbolista = searchedFutbolista.getNif();

		System.out.println(nifFutbolista);
		//Comprueba que solo está relleno el campo de nombre. 
		if (StringUtils.hasText(nomFutbolista) && (!StringUtils.hasText(nifFutbolista) && !StringUtils.hasText(nacFutbolista) && !StringUtils.hasText(fecNac))) {

			// Búsqueda por nombre
			futbolista = futbolistaServiceI.obtenerFutbolistaPorNombre(nomFutbolista);

		} else if (!StringUtils.hasText(nomFutbolista)
				&& (StringUtils.hasText(nifFutbolista) && !StringUtils.hasText(nacFutbolista) && !StringUtils.hasText(fecNac))) {

			//Búsqueda por nif.
			futbolista = futbolistaServiceI.obtenerFutbolistaPorNif(nifFutbolista);

		} else if (!StringUtils.hasText(nomFutbolista)
				&& (!StringUtils.hasText(nifFutbolista) && StringUtils.hasText(nacFutbolista) && !StringUtils.hasText(fecNac))) {

			//Búsqueda por nacionalidad
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorNacionalidad(nacFutbolista);

		} else if (!StringUtils.hasText(nomFutbolista)
				&& (!StringUtils.hasText(nifFutbolista) && !StringUtils.hasText(nacFutbolista) && StringUtils.hasText(fecNac))) {

			//Búsqueda por año de nacimiento
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorAnyoNac(fecNac);

		} else if (StringUtils.hasText(nomFutbolista)
				&& (StringUtils.hasText(nifFutbolista) && !StringUtils.hasText(nacFutbolista) && !StringUtils.hasText(fecNac))) {

			//Búsqueda por nombre y por nif
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorNifYNombre(nifFutbolista, nomFutbolista);

		} else if (StringUtils.hasText(nomFutbolista)
				&& (!StringUtils.hasText(nifFutbolista) && !StringUtils.hasText(nacFutbolista) && StringUtils.hasText(fecNac))) {

			//Búsqueda por nombre y año de nacimiento
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorNombreYAnyoNac(nomFutbolista, fecNac);

		} else if (StringUtils.hasText(nomFutbolista)
				&& (!StringUtils.hasText(nifFutbolista) && StringUtils.hasText(nacFutbolista) && !StringUtils.hasText(fecNac))) {

			//Búsqueda por nombre y nacionalidad
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorNombreYNacionalidad(nomFutbolista, nacFutbolista);

		} else if (!StringUtils.hasText(nomFutbolista)
				&& (!StringUtils.hasText(nifFutbolista) && StringUtils.hasText(nacFutbolista) && StringUtils.hasText(fecNac))) {

			//Búsqueda por año de nacimiento y nacionalidad
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorAnyoNacYNacionalidad(fecNac, nacFutbolista);

		} else if (!StringUtils.hasText(nomFutbolista)
				&& (StringUtils.hasText(nifFutbolista) && !StringUtils.hasText(nacFutbolista) && StringUtils.hasText(fecNac))) {

			//Búsqueda por año de nacimiento y nif
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorAnyoNacYNif(fecNac, nifFutbolista);

		} else if (!StringUtils.hasText(nomFutbolista)
				&& (StringUtils.hasText(nifFutbolista) && StringUtils.hasText(nacFutbolista) && !StringUtils.hasText(fecNac))) {

			//Búsqueda por nif y nacionalidad
			listaFutbolistas = futbolistaServiceI.obtenerFutbolistasPorNifYNacion(nifFutbolista, nacFutbolista);

		} else {
			throw new Exception("Parámetros de búsquieda erróneos.");
		}
		
		if (futbolista != null) {
			listaFutbolistas.add(futbolista);
			System.out.println(listaFutbolistas.size());
		}

		// Carga de datos al modelo
		model.addAttribute("futbolistaListView", listaFutbolistas);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showFutbolistas";

	}
}
