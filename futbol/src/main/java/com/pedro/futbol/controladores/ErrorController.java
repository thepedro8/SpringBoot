package com.pedro.futbol.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/***
 * Clase controlador para la vista de Errores o Excepciones
 * @author Pedro
 *
 */
@ControllerAdvice
public class ErrorController {

	/***
	 * Metodo que muestra las excepciones que se producen a lo largo de la ejecucion del programa
	 * @param req solicitud al servlet
	 * @param e Excepción que se produce
	 * @param model Modelo que pasamos
	 * @return retorna el error cometido
	 */
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception e, Model model) {

		// Respuesta.
		model.addAttribute("errorText", e.getMessage());

		return "error";
	}
}
