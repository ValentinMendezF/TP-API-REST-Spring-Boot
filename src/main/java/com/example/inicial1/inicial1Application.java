package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private LocalidadRepository localidadRepository;


	public static void main(String[] args) {
		SpringApplication.run(inicial1Application.class, args);

		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository) {
		return args -> {
/*			// Creo un objeto persona
			Persona per1 = Persona.builder().
					nombre("Alberto").apellido("Cortez").
					build();

			Domicilio dom1 = Domicilio.builder().
					calle("Suipacha").
					numero(239).build();

			per1.setDomicilio(dom1);
*/
			Localidad localidad1= Localidad.builder()
					.denominacion("Ciudad")
					.build();
			//localidadRepository.save(localidad1);
			Localidad localidad2 = Localidad.builder()
					.denominacion("Godoy Cruz")
					.build();
			//localidadRepository.save(localidad2);
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Rodriguez")
					.numero(122)
					.build();
			domicilio1.getLocalidades().add(localidad1);
			//domicilioRepository.save(domicilio1);
			Domicilio domicilio2 = Domicilio.builder()
					.calle("San Martin")
					.numero(1543)
					.build();
			domicilio2.getLocalidades().add(localidad2);
			//domicilioRepository.save(domicilio2);
			Autor autor1= Autor.builder()
					.nombre("Dan")
					.apellido("Brown")
					.biografia("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
					.build();
			//autorRepository.save(autor1);
			Autor autor2 = Autor.builder()
					.nombre("Miguel")
					.apellido("de Cervantes")
					.biografia(" Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
					.build();
			//autorRepository.save(autor2);
			Libro libro1 = Libro.builder()
					.titulo("El Código da Vinci")
					.fecha(2003)
					.genero("misterio")
					.paginas(300)
					.build();
			libro1.getAutores().add(autor1);
			//libroRepository.save(libro1);
			Libro libro2 = Libro.builder()
					.titulo("Don Quijote de la Mancha")
					.fecha(1615)
					.genero("novela")
					.paginas(400)
					.build();
			libro2.getAutores().add(autor2);
			//libroRepository.save(libro2);
			Persona persona1 = Persona.builder()
					.dni(4875795)
					.nombre("Juan")
					.apellido("Fernandez")
					.domicilio(domicilio1)
					.build();
			persona1.getLibros().add(libro1);
			personaRepository.save(persona1);

/*// Creo otra persona
			Persona per2 = Persona.builder().
					nombre("Alicia").apellido("Calderon").
					build();

			Domicilio dom2 = Domicilio.builder().
					calle("Lulunta").
					numero(339).build();

			per2.setDomicilio(dom2);

*/
			Persona persona2 = Persona.builder()
					.dni(45897687)
					.nombre("Maria")
					.apellido("Gomez")
					.domicilio(domicilio2)
					.build();
			persona2.getLibros().add(libro2);
			// Lo grabo a través del repositorio de Spring
			personaRepository.save(persona2);

			List<Persona> recuperadas = personaRepository.findAll();
			System.out.println(recuperadas);

			logger.info("Detalles de la persona: {}", recuperadas);


			Optional<Persona> recuperada = personaRepository.findById(1L);
			System.out.println(recuperada);

			logger.info("Detalles de la persona: {}", recuperada);


		/*	dom1.setCalle("Rodriguezaaaa");

			personaRepository.save(per1);
		*/

		};

	}

	;


}
