package tesis.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
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
	IndicadorService indicadorService;
	
	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//TESTING 3.0 POSTMAN -- creo indicadores.
	
//		indicadorService.addIndicador(new Indicador("i1", 1.0F));
//		indicadorService.addIndicador(new Indicador("i2", 2.0F));
//		indicadorService.addIndicador(new Indicador("i3", 3.0F));
//		
//		objetivoService.addObjetivo(new Objetivo("o1", "do1"));
//		objetivoService.addObjetivo(new Objetivo("o2", "do2"));
////		objetivoService.addObjetivo(new Objetivo("o3", "do3"));
//		objetivoService.addObjetivoAfectante(1, 2, 10.0f);
//		objetivoService.addObjetivoAfectante(2, 3, 10.0f);
		
//		objetivoService.addIndicadorAfectante(1, 1, 10.0f);
//		objetivoService.addIndicadorAfectante(2, 1, 10.0f);
//		
//		
//		
//		objetivoService.updateObjetivo(2, new Objetivo("o2", "descripcion_long"));
		
//		objetivoService.addObjetivo(new Objetivo("o3", "do3"));
		
		
		///PRUEBA DE INDICADORxObjetivo
		
		indicadorService.addIndicador(new Indicador("i1", 1.0F));
		objetivoService.addObjetivo(new Objetivo("o1", "do1"));
		objetivoService.addObjetivo(new Objetivo("o2", "do2"));
		objetivoService.addIndicadorAfectante(1, 1, 10.0f);
		objetivoService.addObjetivoAfectante(1, 2, 25.0f);
		indicadorService.updateIndicador(1, new Indicador("i1", 5.0F));
		
	}
}
