package tesis.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Estrategia;
import tesis.bsc.model.Objetivo;
import tesis.bsc.model.Perspectiva;
import tesis.bsc.repository.EstrategiaRepository;
import tesis.bsc.repository.PerspectivaRepository;

@SpringBootApplication
public class BscApplication implements CommandLineRunner{
	
	@Autowired
	EstrategiaRepository estrategiaRepository;
	
	@Autowired
	PerspectivaRepository perspectivaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * 1 estrategia
		 * 2 perspectivas
		 * 2 objetivos en la primer perspectiva
		 */
		Estrategia e1 = new Estrategia("e1","m1","v1");
		Perspectiva p1 = new Perspectiva("p1", "d1");
		Perspectiva p2 = new Perspectiva("p2", "d2");
		e1.addPerspectiva(p1);
		e1.addPerspectiva(p2);
		Objetivo o1 = new Objetivo("o1", "d1");
		Objetivo o2 = new Objetivo("o2", "d2");
		p1.addObjetivo(o1);
		p1.addObjetivo(o2);
		
		estrategiaRepository.save(e1);
		perspectivaRepository.save(p1);
		
		/*
		 * 1 estrategia
		 * 2 perspectivas
		 * 1 objetivo por cada perspectiva
		 */
		Estrategia e2 = new Estrategia("e2","m2","v2");
		Perspectiva p3 = new Perspectiva("p3", "d3");
		Perspectiva p4 = new Perspectiva("p4", "d4");
		e2.addPerspectiva(p3);
		e2.addPerspectiva(p4);
		Objetivo o3 = new Objetivo("o3", "d3");
		Objetivo o4 = new Objetivo("o4", "d4");
		p3.addObjetivo(o3);
		p4.addObjetivo(o4);

		estrategiaRepository.save(e2);
		perspectivaRepository.save(p3);
		perspectivaRepository.save(p4);
		
		Estrategia e3 = new Estrategia("e3","m3","v3");
		Perspectiva p5 = new Perspectiva("p5", "d5");
		Perspectiva p6 = new Perspectiva("p6", "d6");
		e3.addPerspectiva(p5);
		e3.addPerspectiva(p6);
		Objetivo o5 = new Objetivo("o5", "d5");
		Objetivo o6 = new Objetivo("o6", "d6");
		p5.addObjetivo(o5);
		p6.addObjetivo(o6);

		estrategiaRepository.save(e3);
		perspectivaRepository.save(p5);
		perspectivaRepository.save(p6);
	}
}
