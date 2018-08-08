package tesis.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.repository.IndicadorRepository;
import tesis.bsc.service.EstrategiaService;
import tesis.bsc.service.ObjetivoService;
import tesis.bsc.service.PerspectivaService;

@SpringBootApplication
public class BscApplication implements CommandLineRunner{
	
	@Autowired
	EstrategiaService estrategiaService;
	
	@Autowired
	PerspectivaService perspectivaService;
	
	@Autowired
	ObjetivoService objetivoService;
	
	@Autowired
	IndicadorRepository indicadorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//TESTING 3.0 POSTMAN -- creo indicadores.
	
		indicadorRepository.save(new Indicador("i1", 1.0F));
		indicadorRepository.save(new Indicador("i2", 2.0F));
		indicadorRepository.save(new Indicador("i3", 3.0F));
		
//		objetivoService.addObjetivo(new Objetivo("o1", "do1"));
//		objetivoService.addObjetivo(new Objetivo("o2", "do2"));
//		objetivoService.addObjetivo(new Objetivo("o3", "do3"));
		
	}
}
