package tesis.bsc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tesis.bsc.model.Estrategia;
import tesis.bsc.model.Indicador;
import tesis.bsc.model.IndicadorXObjetivo;
import tesis.bsc.model.Objetivo;
import tesis.bsc.model.Perspectiva;
import tesis.bsc.repository.EstrategiaRepository;
import tesis.bsc.repository.IndicadorRepository;
import tesis.bsc.repository.ObjetivoRepository;
import tesis.bsc.repository.PerspectivaRepository;
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
		
		/*
		 * 1 estrategia
		 * 2 perspectivas
		 * 2 objetivos en la primer perspectiva
		 */
		
//		Estrategia e1 = new Estrategia("e1","m1","v1");
//		Perspectiva p1 = new Perspectiva("p1", "d1");
//		Perspectiva p2 = new Perspectiva("p2", "d2");
//		e1.addPerspectiva(p1);
//		e1.addPerspectiva(p2);
//		Objetivo o1 = new Objetivo("o1", "d1");
//		Objetivo o2 = new Objetivo("o2", "d2");
//		p1.addObjetivo(o1);
//		p1.addObjetivo(o2);
//		
//		estrategiaService.addEstrategia(e1);
//		perspectivaService.addPerspectiva(p1);
		
		/*
		 * 1 estrategia
		 * 2 perspectivas
		 * 1 objetivo por cada perspectiva
//		 */
		
//		Estrategia e2 = new Estrategia("e2","m2","v2");
//		Perspectiva p3 = new Perspectiva("p3", "d3");
//		Perspectiva p4 = new Perspectiva("p4", "d4");
//		e2.addPerspectiva(p3);
//		e2.addPerspectiva(p4);
//		Objetivo o3 = new Objetivo("o3", "d3");
//		Objetivo o4 = new Objetivo("o4", "d4");
//		p3.addObjetivo(o3);
//		p4.addObjetivo(o4);
//
//		e2 = estrategiaService.addEstrategia(e2);
//		p3 = perspectivaService.addPerspectiva(p3);
//		p4 = perspectivaService.addPerspectiva(p4);
//		
//		Estrategia e3 = new Estrategia("e3","m3","v3");
//		Perspectiva p5 = new Perspectiva("p5", "d5");
//		Perspectiva p6 = new Perspectiva("p6", "d6");
//		e3.addPerspectiva(p5);
//		e3.addPerspectiva(p6);
//		Objetivo o5 = new Objetivo("o5", "d5");
//		Objetivo o6 = new Objetivo("o6", "d6");
//		p5.addObjetivo(o5);
//		p6.addObjetivo(o6);
//
//		e3 = estrategiaService.addEstrategia(e3);
//		p5 = perspectivaService.addPerspectiva(p5);
//		p6 = perspectivaService.addPerspectiva(p6);
		
		
		
		
//		/*
//		 * Creo 2 objetivos
//		 * Creo 2 indicadores
//		 * El objetivo o20 tiene 2 relaciones, con i20 y i21.
//		 * El objetivo o21 tiene 2 relacion, con i20 y i21.
//		 */
//		
//		o1 = objetivoService.getObjetivo(1);
//		o2 = objetivoService.getObjetivo(2);
//		
//		
//		Indicador i20 = new Indicador("i20", 80.0F);
//		i20 = indicadorRepository.save(i20);
//		
//		Hibernate.initialize(o1.getIndicadoresAfectantes());
//		o1.addIndicador(i20, 25.6F);
//		o2.addIndicador(i20, 2.6F);
//		
//		o1 = objetivoService.addObjetivo(o1);
//		o2 = objetivoService.addObjetivo(o2);
//		
//		Indicador i21 = new Indicador("i21", 33.0F);
//		i21 = indicadorRepository.save(i21);
//		o1.addIndicador(i21, 12.6F);
//		o2.addIndicador(i21, 9.6F);
//		o1 = objetivoService.addObjetivo(o1);
//		o2 = objetivoService.addObjetivo(o2);
//		
//		i20 = indicadorRepository.findById(1).orElse(null);
//		o20.removeIndicador(i20);
//		objetivoService.addObjetivo(o20);
			
		
		//TESTING LAZY
		
//		Objetivo o1 = new Objetivo("o1", "d1");
//		o1 = objetivoService.addObjetivo(o1);
//		
//		Objetivo o2 = new Objetivo("o2", "d2");
//		o2 = objetivoService.addObjetivo(o2);
//		
//		Indicador i1 = new Indicador("i1", 1.0F);
//		i1 = indicadorRepository.save(i1);
//		
//		objetivoService.addIndicadorAfectante(1, i1.getId(), 1.0F);
//		objetivoService.addIndicadorAfectante(2, i1.getId(), 23.5F);
		
		//TESTING 3.0 -- creo indicadores.
		Indicador i1 = new Indicador("i1", 1.0F);
		i1 = indicadorRepository.save(i1);
		Indicador i2 = new Indicador("i2", 2.0F);
		i2 = indicadorRepository.save(i2);
		Indicador i3 = new Indicador("i3", 3.0F);
		i3 = indicadorRepository.save(i3);
		Indicador i4 = new Indicador("i4", 4.0F);
		i4 = indicadorRepository.save(i4);
		
	}
}
