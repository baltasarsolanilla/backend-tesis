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
import tesis.bsc.service.ObjetivoService;

@SpringBootApplication
public class BscApplication implements CommandLineRunner{
	
	@Autowired
	EstrategiaRepository estrategiaRepository;
	
	@Autowired
	PerspectivaRepository perspectivaRepository;
	
//	@Autowired
//	ObjetivoRepository objetivoRepository;
	
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
//		estrategiaRepository.save(e1);
//		perspectivaRepository.save(p1);
//		
//		/*
//		 * 1 estrategia
//		 * 2 perspectivas
//		 * 1 objetivo por cada perspectiva
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
//		e2 = estrategiaRepository.save(e2);
//		p3 = perspectivaRepository.save(p3);
//		p4 = perspectivaRepository.save(p4);
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
//		e3 = estrategiaRepository.save(e3);
//		p5 = perspectivaRepository.save(p5);
//		p6 = perspectivaRepository.save(p6);
//		
//		
//		
//		
//		/*
//		 * Creo 2 objetivos
//		 * Creo 2 indicadores
//		 * El objetivo o20 tiene 2 relaciones, con i20 y i21.
//		 * El objetivo o21 tiene 2 relacion, con i20 y i21.
//		 */
//		
//		o1 = objetivoRepository.findById(1).orElse(null);
//		o2 = objetivoRepository.findById(2).orElse(null);
//		
//		
//		Indicador i20 = new Indicador("i20", 80.0F);
//		i20 = indicadorRepository.save(i20);
//		
//		Hibernate.initialize(o1.getIndicadoresAfectantes());
//		o1.addIndicador(i20, 25.6F);
//		o2.addIndicador(i20, 2.6F);
//		
//		o1 = objetivoRepository.save(o1);
//		o2 = objetivoRepository.save(o2);
//		
//		Indicador i21 = new Indicador("i21", 33.0F);
//		i21 = indicadorRepository.save(i21);
//		o1.addIndicador(i21, 12.6F);
//		o2.addIndicador(i21, 9.6F);
//		o1 = objetivoRepository.save(o1);
//		o2 = objetivoRepository.save(o2);
		
//		i20 = indicadorRepository.findById(1).orElse(null);
//		o20.removeIndicador(i20);
//		objetivoRepository.save(o20);
			
		
		//TESTING LAZY
		
//		ObjetivoService objetivoService = new ObjetivoService();
		
		Objetivo o1 = new Objetivo("o1", "d1");
		objetivoService.save(o1);
		
		Indicador i1 = new Indicador("i1", 1.0F);
		indicadorRepository.save(i1);
		
		
		objetivoService.addIndicador(1, i1);
	}
}
