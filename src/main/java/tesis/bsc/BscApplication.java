package tesis.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Estrategia;
import tesis.bsc.repository.EstrategiaRepository;

@SpringBootApplication
public class BscApplication implements CommandLineRunner{
	
	@Autowired
	EstrategiaRepository estrategiaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Estrategia e1 = new Estrategia("e1","m1","v1");
		Estrategia e2 = new Estrategia("e2","m2","v2");
		estrategiaRepository.save(e1);
		estrategiaRepository.save(e2);
	}
}
