package com.pedro.futbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.servicios.EquiposServiceI;

/***
 * Clase principal de la aplicación.
 * @author Pedro
 */
@SpringBootApplication
public class FutbolApplication implements CommandLineRunner{
	
	@Autowired
	private EquiposServiceI eqService;

	/***
	 * Método principal donde la aplicación de Spring
	 * @param args Argumentos
	 */
	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
