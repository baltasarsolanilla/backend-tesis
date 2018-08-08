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
		Indicador i1 = new Indicador("i1", 1.0F);
		i1 = indicadorRepository.save(i1);
		Indicador i2 = new Indicador("i2", 2.0F);
		i2 = indicadorRepository.save(i2);
		Indicador i3 = new Indicador("i3", 3.0F);
		i3 = indicadorRepository.save(i3);
		Indicador i4 = new Indicador("i4", 4.0F);
		i4 = indicadorRepository.save(i4);
		
		objetivoService.addObjetivo(new Objetivo("o1", "do1"));
		objetivoService.addObjetivo(new Objetivo("o2", "do2"));
		objetivoService.addObjetivo(new Objetivo("o3", "do3"));
		
	}
}
