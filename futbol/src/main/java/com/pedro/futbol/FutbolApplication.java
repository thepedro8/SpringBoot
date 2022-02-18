package com.pedro.futbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.futbol.entidades.Equipo;
import com.pedro.futbol.servicios.EquiposServiceI;

@SpringBootApplication
public class FutbolApplication implements CommandLineRunner{
	
	@Autowired
	private EquiposServiceI eqService;

	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Equipo equipo = new Equipo();
		//equipo.setNombre("Sporting Benameji");
		//equipo.setAnyoCrea("1992");
		//equipo.setEstadio("Campo de futbol de Benamejí");
		
		//eqService.aniadirEquipo(equipo);

	//	System.out.println("------------");

		//Obtención e iteración de elementos.
//		final List<Coche> CarList = cocheServiceI.obtenerTodosCoches();
//		if (!CollectionUtils.isEmpty(CarList)) {
//			for (Coche coche : CarList) {
//				System.out.println(coche.toString());
//			}
//		}
//		
//		System.out.println("------------");
				
		// Obtención e iteración de elementos.
//		final List<Coche> CarMarOMod = cocheServiceI.obtenerCochePorMarcaOModelo("Ford", "León");
//		if (!CollectionUtils.isEmpty(CarMarOMod)) {
//			for (Coche coche : CarMarOMod) {
//				System.out.println(coche.toString());
//			}
//		}
//		
//		 System.out.println("------------");
		
		 //Búsqueda por matrícula.
//		final Coche cochePorMatricula = cocheServiceI.obtenerCochePorMatricula("1986-HBU");
//		System.out.println(cochePorMatricula.toString());
		
		//Eliminar coche por Id
//		cocheServiceI.eliminarCochePorId(cochePorMatricula.getId());
				
		//Añadir un coche
//		Coche car = new Coche();
//		car.setMatricula("0000 AAA");
//		car.setMarca("Opel");
//		car.setModelo("Astra");
//				
//		cocheServiceI.aniadirCoche(car);

	}
}
