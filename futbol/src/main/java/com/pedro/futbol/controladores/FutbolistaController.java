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

/***
 * Clase controlador para las vistas que interactúan con la clase Futbolistas
 * @author Pedro
 *
 */
@Controller
public class FutbolistaController {
	
	@Autowired
	private FutbolistasServiceI futbolistaServiceI;
	
	
	/***
	 * Método que carga la vista con los datos de todo los futbolistas encontrados en la base de datos.
	 * @param model Representa la vista
	 * @return Retorna la vista con los datos de todo los futbolistas encontrados.
	 */
	@GetMapping("/showFutbolistasView")
	public String mostrarFutbolistas(Model model) {

		// Obtención de futbolistas
		final List<Futbolistas> listaFutbolista = futbolistaServiceI.obtenerTodosFutbolistas();

		// Carga de datos al modelo
		model.addAttribute("futbolistaListView", listaFutbolista);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showFutbolistas";
	}

	
	
	/***
	 * Método que se utiliza para eliminar a un futbolista de la base de datos.
	 * @param futId Id del futbolista a eliminar.
	 * @param model Representa la vista
	 * @return Retorna el listado de futbolista que se encuentran en la base de datos y así ver los cambios realizados.
	 */
	@PostMapping("/actDropFutbolista")
	public String eliminarFutbolista(@RequestParam long futId, Model model) {

		// Eliminación de futbolista
		futbolistaServiceI.eliminarFutbolistaPorId(futId);

		return "redirect:showFutbolistasView";

	}
	
	
	
	/***
	 * Método que utilizamos para añadir futbolistas a la base de datos.
	 * @param newFutbolista Objeto que contiene los datos del futbolista a añadir en la base de datos.
	 * @param result Resultado de la validacion del objeto
	 * @return Retorna una vista con los datos de los futbolistas cargados en la lista para poder comprobar los cambios.
	 * @throws Exception Controla que el formato de datos introducidos sean correctos.
	 */
	@PostMapping("/actAddFutbolista")
	private String aniadirFutbolista(@ModelAttribute Futbolistas newFutbolista, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			final String fecNac = newFutbolista.getAnyoNac();
			if(!fecNac.isEmpty()) {
				int anyo = Integer.parseInt(fecNac);
				
				if(anyo<=0 || anyo>2999 ) {
					throw new Exception("No se puede introducir un año menor o igual a 0 o mayor a 2999");
				}
			}
				
			// Se añade el nuevo coche
			futbolistaServiceI.aniadirFutbolista(newFutbolista);
		}

		return "redirect:showFutbolistasView";
	}
	

	/***
	 * Método que se utiliza para buscar a los futbolistas según los atributos que reciba.
	 * @param searchedFutbolista Objeto que contiene los datos a buscar en la base de datos.
	 * @param model Representa la vista
	 * @return Retorna la lista de futbolistas que cumplen con la búsqueda.
	 * @throws Exception Controlamos que los datos tengan formatos correctos.
	 */
	@PostMapping("/actSearchFutbolista")
	public String submitBuscarFutbolistaForm(@ModelAttribute Futbolistas searchedFutbolista, Model model) throws Exception {

		List<Futbolistas> listaFutbolistas = new ArrayList<Futbolistas>();
		Futbolistas futbolista = null;
		

		final String nomFutbolista = searchedFutbolista.getNombre();
		final String nacFutbolista = searchedFutbolista.getNacionalidad();
		final String fecNac = searchedFutbolista.getAnyoNac();
		final String nifFutbolista = searchedFutbolista.getNif();

		if(!fecNac.isEmpty()) {
			int anyo = Integer.parseInt(fecNac);
			
			if(anyo<=0 || anyo>2999 ) {
				throw new Exception("No se puede introducir un año menor o igual a 0 o mayor a 2999");
			}
		}
		
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
		}

		// Carga de datos al modelo
		model.addAttribute("futbolistaListView", listaFutbolistas);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showFutbolistas";

	}
	
	
	
	/***
	 * Método que sirve para recoger los datos que tenemos del futbolista seleccionado en la base de datos.
	 * @param futId Id del futbolista que vamos a editar
	 * @param model Representa la vista
	 * @return Retorna la vista de edición de futbolistas donde se van a mostrar los datos cargados extraidos de la base de datos.
	 */
	 @GetMapping("/editFutbolistaView")
		public String recogerFutbolista(String futId, Model model) {

			// Obtención de equipos

		  	long idFutbolista = Long.valueOf(futId);
		  
			Futbolistas f = futbolistaServiceI.obtenerFutbolistaPorId(idFutbolista);

			// Carga de datos al modelo
			model.addAttribute("id", f.getId());
			model.addAttribute("nombre", f.getNombre());
			model.addAttribute("anyoNac", f.getAnyoNac());
			model.addAttribute("nacionalidad", f.getNacionalidad());
			model.addAttribute("nif", f.getNif());

			return "editFutbolista";
		}
	 
	 
	
	 /***
	  * Método que sirve para recoger los datos de los campos de la vista para ser cargados en la base de datos. 
	  * @param editFutbolista Objeto donde recogemos los datos de los campos de la vista.
	  * @param result Resultado de la validacion del objeto
	  * @return Retorna la vista de mostrar todos los fubtolistas para ver los cambios realizados.
	  * @throws Exception Controlamos que los datos tengan formatos correctos.
	  */
	@PostMapping("/actEditFutbolista")
	public String editarEquipo(@ModelAttribute Futbolistas editFutbolista, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {
			
			long idFutbolista = Long.valueOf(editFutbolista.getId());
			Futbolistas f = futbolistaServiceI.obtenerFutbolistaPorId(idFutbolista);

			f.setNombre(editFutbolista.getNombre());
			f.setAnyoNac(editFutbolista.getAnyoNac());
			f.setNacionalidad(editFutbolista.getNacionalidad());
			f.setNif(editFutbolista.getNif());

			futbolistaServiceI.actualizarFutbolista(f);
		}

		return "redirect:showFutbolistasView";
	}
}
