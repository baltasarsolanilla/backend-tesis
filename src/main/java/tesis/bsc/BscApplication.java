package tesis.bsc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.repository.ObjetivoRepository;
import tesis.bsc.service.EstrategiaService;
import tesis.bsc.service.ObjetivoService;
import tesis.bsc.service.PerspectivaService;
import tesis.bsc.service.IndicadorService;

@SpringBootApplication
public class BscApplication implements CommandLineRunner{
	
	@Autowired
	EstrategiaService estrategiaService;
	
	@Autowired
	PerspectivaService perspectivaService;
	
	@Autowired
	ObjetivoService objetivoService;
	
	@Autowired
	private ObjetivoRepository objetivoRepository;
	
	@Autowired
	IndicadorService indicadorService;
	
	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//TEST Historico
		
//		indicadorService.addIndicador(new Indicador("i1", 2.0F));
//		indicadorService.addIndicador(new Indicador("i2", 3.0F));
//		indicadorService.addIndicador(new Indicador("i3", 5.0F));
//		
//		objetivoService.addObjetivo(new Objetivo("o1", "do1"));
//		objetivoService.addObjetivo(new Objetivo("o2", "do2"));
//		objetivoService.addObjetivo(new Objetivo("o3", "do3"));
		
//		objetivoService.addIndicadorAfectante(1, 4, 2.0f);
//		objetivoService.addIndicadorAfectante(2, 5, 3.0f);
//		objetivoService.addIndicadorAfectante(3, 6, 5.0f);
//		
//		objetivoService.addObjetivoAfectante(1, 5, 2.0f); // 1 <- 2
//		objetivoService.addObjetivoAfectante(2, 6, 3.0f); // 1 <- 2	
		
		//NUEVOS CAMBIOS
		
		


		// Do some work & in the mean time the database has been updated by a batch job

		// refresh object and now up to date

//		Objetivo oRev0 = objetivoService.findObjRevision(1, 1);
//		Objetivo oRev1 = objetivoService.findObjRevision(1, 4);
//		Objetivo oRev2 = objetivoService.findObjRevision(1, 7);
//		Objetivo oRev3 = objetivoService.findObjRevision(1, 8);
		
	}
}
