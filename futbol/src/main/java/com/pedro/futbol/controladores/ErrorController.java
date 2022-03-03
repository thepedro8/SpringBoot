package com.pedro.futbol.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

	/***
	 * Metodo que muestra las excepciones que se producen a lo largo de la ejecucion del programa
	 * @param req
	 * @param e excepcion
	 * @param model modelo necesario
	 * @return la excepcion que ha saltado
	 */
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception e, Model model) {

		// Respuesta.
		model.addAttribute("errorText", e.getMessage());

		return "error";
	}
}
