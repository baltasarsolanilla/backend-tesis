package tesis.bsc;

import java.util.List;

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
		indicadorService.addIndicador(new Indicador("i1", 2.0F));
		indicadorService.addIndicador(new Indicador("i2", 3.0F));
		indicadorService.addIndicador(new Indicador("i3", 5.0F));
		
		objetivoService.addObjetivo(new Objetivo("o1", "do1"));
		objetivoService.addObjetivo(new Objetivo("o2", "do2"));
		objetivoService.addObjetivo(new Objetivo("o3", "do3"));
		
		objetivoService.addIndicadorAfectante(1, 1, 2.0f);
		objetivoService.addIndicadorAfectante(2, 2, 3.0f);
		objetivoService.addIndicadorAfectante(3, 3, 5.0f);
		
		objetivoService.addObjetivoAfectante(1, 2, 2.0f); // 1 <- 2
		objetivoService.addObjetivoAfectante(2, 3, 3.0f); // 1 <- 2
		
		//Formula: ox = i.val * peso + o.val * peso
		//Valores esperados:
		/*
		 * o1 = 2 * 2 + o2.val(84) * 2 -- o1 = 172
		 * o2 = 3 * 3 + o3.val(25) * 3 -- o2 = 84
		 * o3 = 5 * 5 -- o3 = 25
		 */
		List<Objetivo> objs1 = objetivoService.findAllObjetivos();
		
		indicadorService.updateIndicador(2, new Indicador("i1", 7.0f));
		//Formula: ox = i.val * peso + o.val * peso
		//Valores esperados:
		/*
		 * o1 = 2 * 2 + o2.val(96) * 2 -- o1 = 196
		 * o2 = 7 * 3 + o3.val(25) * 3 -- o2 = 96
		 * o3 = 5 * 5 -- o3 = 25
		 */
		List<Objetivo> objs2 = objetivoService.findAllObjetivos();
		
		objetivoService.deleteObjetivoAfectante(2, objetivoService.getObjetivo(3));
		//Formula: ox = i.val * peso + o.val * peso
		//Valores esperados:
		/*
		 * o1 = 2 * 2 + o2.val(21) * 2 -- o1 = 46
		 * o2 = 7 * 3 + o3.val(0) * 3 -- o2 = 21
		 * o3 = 5 * 5 -- o3 = 25
		 */
		List<Objetivo> objs3 = objetivoService.findAllObjetivos();
//		objetivoService.deleteObjetivo(2);
//		indicadorService.deleteIndicador(1);
		
	}
}
