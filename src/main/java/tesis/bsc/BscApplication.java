package tesis.bsc;

import java.util.ArrayList;
import java.util.List;

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

@SpringBootApplication
public class BscApplication implements CommandLineRunner{
	
	@Autowired
	EstrategiaRepository estrategiaRepository;
	
	@Autowired
	PerspectivaRepository perspectivaRepository;
	
	@Autowired
	ObjetivoRepository objetivoRepository;
	
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
//		estrategiaRepository.save(e2);
//		perspectivaRepository.save(p3);
//		perspectivaRepository.save(p4);
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
//		estrategiaRepository.save(e3);
//		perspectivaRepository.save(p5);
//		perspectivaRepository.save(p6);
		
		//TEST 2.0
		/*
		 * Creo 2 objetivos
		 * Creo 2 perspectivas
		 * Creo 3 relaciones IndicadorXObjetivo
		 * El objetivo o20 tiene 2 relaciones, con i20 y i21.
		 * El objetivo o21 tiene 1 relacion, con i20.
		 */
		
		Objetivo o20 = new Objetivo("o20", "d20");
		o20 = objetivoRepository.save(o20);
		
		Objetivo o21 = new Objetivo("o21", "d21");
		o21 = objetivoRepository.save(o21);
		
		Indicador i20 = new Indicador("i20", 80.0F);
		i20 = indicadorRepository.save(i20);
		o20.addIndicador(i20, 25.6F);
		o21.addIndicador(i20, 2.6F);
		
		o20 = objetivoRepository.save(o20);
		o21 = objetivoRepository.save(o21);
		
		Indicador i21 = new Indicador("i21", 33.0F);
		i21 = indicadorRepository.save(i21);
		o20.addIndicador(i21, 12.6F);
		o21.addIndicador(i21, 9.6F);
		o20 = objetivoRepository.save(o20);
		o21 = objetivoRepository.save(o21);
		
//		i20 = indicadorRepository.findById(1).orElse(null);
//		o20.removeIndicador(i20);
//		objetivoRepository.save(o20);
			
	}
}
