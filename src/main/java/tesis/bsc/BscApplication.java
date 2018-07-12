package tesis.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Estrategia;
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
		Estrategia e1 = new Estrategia("e1","m1","v1");
		Perspectiva p1 = new Perspectiva("p1", "d1");
		Perspectiva p2 = new Perspectiva("p2", "d2");
		e1.addPerspectiva(p1);
		e1.addPerspectiva(p2);
		
		//Cuando persisto el padre, se persisten los hijos.
		//No funciona al revés.
		estrategiaRepository.save(e1);
		
		Estrategia e2 = new Estrategia("e2","m2","v2");
		Perspectiva p3 = new Perspectiva("p3", "d3");
		Perspectiva p4 = new Perspectiva("p4", "d4");
		e1.addPerspectiva(p3);
		e1.addPerspectiva(p4);
		
		//Cuando persisto el padre, se persisten los hijos.
		//No funciona al revés.
		estrategiaRepository.save(e2);
	}
}
