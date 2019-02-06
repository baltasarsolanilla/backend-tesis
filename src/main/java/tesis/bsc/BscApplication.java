package tesis.bsc;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tesis.bsc.model.Estrategia;
import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.model.Perspectiva;
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

		//Base con el siguiente formato:
		/*
		 * Technisys RQT
		 * Mision: Facilitar la vida de las personas a través de la mejor experiencia digital en servicios financieros.
		 * Vision: Ser la compañía líder en soluciones de tecnología para la banca digital en el mercado global.
		 *
		 * Financiera
		 * 		1) Ingresos (R-2,3)
		 * 			i1_A) ...
		 * 			i1_B) ...
		 * 		2) Utilidades (R-4)
		 * 		3) Capitalizacion (R-6)
		 * Clientes
		 * 		4) Posicionamiento en el mercado (R-7)
		 * 		5) Incrementar no. clientes (R-8)
		 * 		6) Fidelización de clientes (R-9)
		 * Procesos internos
		 * 		7) Optimizar procesos (R-11)
		 * 		8) Documentar nuevos desarrollos (R-11)
		 * 		9) Investigar nuevas tecnologías (R-12)
		 * Aprendizaje y crecimiento
		 * 		10) Crecimiento profesional
		 * 		11) Traspaso funciones internas (R-10)
		 * 		12) Bienestar
		 *
		 * NOTA: todos tienen exactamente 2 indicadores. Que van de la forma:
		 * Si el objetivo es 3) entonces los indicadores son i3-A y i3-B,
		 * el nro es random entre 0-10.
		 */

		//Creo estrategia
//		String descripcion="Facilitar la vida de las personas a través de la mejor experiencia digital en servicios financieros.";
//		//String vision="Ser la compañía líder en soluciones de tecnología para la banca digital en el mercado global.";
//		estrategiaService.addEstrategia(new Estrategia("Technisys RQT", descripcion));
//
//		//Creo perspectivas
//		perspectivaService.addPerspectiva(new Perspectiva("1 Financiera", "Descripcion financiera..."));
//		perspectivaService.addPerspectiva(new Perspectiva("2 Clientes", "Descripcion clientes..."));
//		perspectivaService.addPerspectiva(new Perspectiva("3 Procesos internos", "Descripcion procesos internos..."));
//		perspectivaService.addPerspectiva(new Perspectiva("4 Aprendizaje y crecimiento", "Descripcion aprendizaje y crecimiento..."));
//
//		//Creo objetivos
//		objetivoService.addObjetivo(new Objetivo("1 Ingresos","Descripcion ingresos..."));
//		objetivoService.addObjetivo(new Objetivo("2 Utilidades","Descripcion utilidades..."));
//		objetivoService.addObjetivo(new Objetivo("3 Capitalizacion","Descripcion capitalizacion..."));
//		objetivoService.addObjetivo(new Objetivo("4 Posicionamiento en el mercado","Descripcion Posicionamiento en el mercado..."));
//		objetivoService.addObjetivo(new Objetivo("5 Incrementar no. clientes","Descripcion incrementar no. clientes..."));
//		objetivoService.addObjetivo(new Objetivo("6 Fidelizacion de clientes","Descripcion fidelizacion de clientes..."));
//		objetivoService.addObjetivo(new Objetivo("7 Optimizar procesos","Descripcion optimizar procesos..."));
//		objetivoService.addObjetivo(new Objetivo("8 Documentar nuevos desarrollow","Descripcion documentar nuevos desarrollow..."));
//		objetivoService.addObjetivo(new Objetivo("9 Investigar nuevas tecnologias","Descripcion investigar nuevas tecnologias..."));
//		objetivoService.addObjetivo(new Objetivo("10 Crecimiento profesional","Descripcion crecimiento profesional..."));
//		objetivoService.addObjetivo(new Objetivo("11 Traspaso funciones internas","Descripcion traspaso funciones internas..."));
//		objetivoService.addObjetivo(new Objetivo("12 Bienestar","Descripcion bienestar..."));
//
//		//Creo indicadores
//		indicadorService.addIndicador(new Indicador("1 i1-A", 1.0f));
//		indicadorService.addIndicador(new Indicador("2 i1-B", 2.0f));
//		indicadorService.addIndicador(new Indicador("3 i2-A", 3.0f));
//		indicadorService.addIndicador(new Indicador("4 i2-B", 4.0f));
//		indicadorService.addIndicador(new Indicador("5 i3-A", 5.0f));
//		indicadorService.addIndicador(new Indicador("6 i3-B", 6.0f));
//		indicadorService.addIndicador(new Indicador("7 i4-A", 7.0f));
//		indicadorService.addIndicador(new Indicador("8 i4-B", 8.0f));
//		indicadorService.addIndicador(new Indicador("9 i5-A", 9.0f));
//		indicadorService.addIndicador(new Indicador("10 i5-B", 10.0f));
//		indicadorService.addIndicador(new Indicador("11 i6-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("12 i6-B", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("13 i7-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("14 i7-B", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("15 i8-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("16 i8-B", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("17 i9-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("18 i9-B", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("19 i10-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("20 i10-B", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("21 i11-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("22 i11-B", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("23 i12-A", nroRandomDIEZ()));
//		indicadorService.addIndicador(new Indicador("24 i12-B", nroRandomDIEZ()));
//
//		//Relaciono las perspectivas-estrategias
//		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(1));
//		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(2));
//		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(3));
//		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(4));
//
//		//Relaciono los objetivos-perspectivas
//		perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(1));
//		perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(2));
//		perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(3));
//		perspectivaService.addObjetivoAfectante(2, objetivoService.getObjetivo(4));
//		perspectivaService.addObjetivoAfectante(2, objetivoService.getObjetivo(5));
//		perspectivaService.addObjetivoAfectante(2, objetivoService.getObjetivo(6));
//		perspectivaService.addObjetivoAfectante(3, objetivoService.getObjetivo(7));
//		perspectivaService.addObjetivoAfectante(3, objetivoService.getObjetivo(8));
//		perspectivaService.addObjetivoAfectante(3, objetivoService.getObjetivo(9));
//		perspectivaService.addObjetivoAfectante(4, objetivoService.getObjetivo(10));
//		perspectivaService.addObjetivoAfectante(4, objetivoService.getObjetivo(11));
//		perspectivaService.addObjetivoAfectante(4, objetivoService.getObjetivo(12));
//
//
//		//Relaciono los objetivos-objetivos
//		//Los objetivos 10 y 12 no tienen dependencias
//		objetivoService.addObjetivoAfectante(1,2);
//		objetivoService.addObjetivoAfectante(1,3);
//		objetivoService.addObjetivoAfectante(2,4);
//		objetivoService.addObjetivoAfectante(3,6);
//		objetivoService.addObjetivoAfectante(4,7);
//		objetivoService.addObjetivoAfectante(5,8);
//		objetivoService.addObjetivoAfectante(6,9);
//		objetivoService.addObjetivoAfectante(7,11);
//		objetivoService.addObjetivoAfectante(8,11);
//		objetivoService.addObjetivoAfectante(9,12);
//		objetivoService.addObjetivoAfectante(11,12);
//
//
//		//Relaciono los indicadores-objetivos
//		objetivoService.addIndicadorAfectante(1, 1, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(1, 2, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(2, 3, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(2, 4, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(3, 5, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(3, 6, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(4, 7, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(4, 8, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(5, 9, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(5, 10, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(6, 11, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(6, 12, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(7, 13, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(7, 14, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(8, 15, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(8, 16, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(9, 17, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(9, 18, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(10, 19, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(10, 20, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(11, 21, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(11, 22, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(12, 23, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(12, 24, nroRandomUNO());
//
//		//////////////////////////////////////////////////////////////////////////
//		//Segunda estrategia para realizar otras pruebas:
//		////////////////////////////////////////////////////////////////////////
//
//		String descripcion2="Build files for all directives are distributed in several flavours: minified for production usage, un-minifi.";
//		//String vision2="All the options are described and can be downloaded from here. It should be noted that the.";
//		estrategiaService.addEstrategia(new Estrategia("Laboratorio XXX", descripcion2));
//
//		//Creo perspectivas
//		perspectivaService.addPerspectiva(new Perspectiva("5 Financiera", "Descripcion financiera 2..."));
//		perspectivaService.addPerspectiva(new Perspectiva("6 Clientes", "Descripcion clientes 2..."));
//		perspectivaService.addPerspectiva(new Perspectiva("7 Procesos internos", "Descripcion procesos internos 2..."));
//		perspectivaService.addPerspectiva(new Perspectiva("8 Aprendizaje y crecimiento", "Descripcion aprendizaje y crecimiento 2..."));
//
//		//Creo objetivos
//		objetivoService.addObjetivo(new Objetivo("13 Ingresos","Descripcion ingresos..."));
//		objetivoService.addObjetivo(new Objetivo("16 Posicionamiento en el mercado","Descripcion Posicionamiento en el mercado..."));
//		objetivoService.addObjetivo(new Objetivo("17 Incrementar no. clientes","Descripcion incrementar no. clientes..."));
//		objetivoService.addObjetivo(new Objetivo("18 Fidelizacion de clientes","Descripcion fidelizacion de clientes..."));
//		objetivoService.addObjetivo(new Objetivo("19 Optimizar procesos","Descripcion optimizar procesos..."));
//		objetivoService.addObjetivo(new Objetivo("20 Documentar nuevos desarrollow","Descripcion documentar nuevos desarrollow..."));
//		objetivoService.addObjetivo(new Objetivo("21 Investigar nuevas tecnologias","Descripcion investigar nuevas tecnologias..."));
//
//		//Relaciono las perspectivas-estrategias
//		estrategiaService.addPerspectivaAfectante(2, perspectivaService.getPerspectiva(5));
//		estrategiaService.addPerspectivaAfectante(2, perspectivaService.getPerspectiva(6));
//		estrategiaService.addPerspectivaAfectante(2, perspectivaService.getPerspectiva(7));
//		estrategiaService.addPerspectivaAfectante(2, perspectivaService.getPerspectiva(8));
//
//		//Relaciono los objetivos-perspectivas
//		perspectivaService.addObjetivoAfectante(5, objetivoService.getObjetivo(13));
//		perspectivaService.addObjetivoAfectante(6, objetivoService.getObjetivo(14));
//		perspectivaService.addObjetivoAfectante(6, objetivoService.getObjetivo(15));
//		perspectivaService.addObjetivoAfectante(7, objetivoService.getObjetivo(16));
//		perspectivaService.addObjetivoAfectante(7, objetivoService.getObjetivo(17));
//		perspectivaService.addObjetivoAfectante(8, objetivoService.getObjetivo(18));
//		perspectivaService.addObjetivoAfectante(8, objetivoService.getObjetivo(19));
//
//		//Relaciono los objetivos-objetivos
//		//Los objetivos 10 y 12 no tienen dependencias
//		objetivoService.addObjetivoAfectante(13,14);
//		objetivoService.addObjetivoAfectante(13,15);
//		objetivoService.addObjetivoAfectante(14,16);
//		objetivoService.addObjetivoAfectante(15,17);
//		objetivoService.addObjetivoAfectante(16,18);
//		objetivoService.addObjetivoAfectante(17,19);
//
//		//Relaciono los indicadores-objetivos (3 cada uno)
//		objetivoService.addIndicadorAfectante(13, 1, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(13, 2, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(13, 3, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(14, 4, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(14, 5, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(14, 6, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(15, 7, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(15, 8, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(15, 9, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(16, 10, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(16, 11, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(16, 12, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(17, 13, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(17, 14, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(17, 15, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(18, 16, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(18, 17, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(18, 18, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(19, 19, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(19, 20, nroRandomUNO());
//		objetivoService.addIndicadorAfectante(19, 21, nroRandomUNO());
//
//		//////////////////////////////////////////////////////////////////////////
//		//Tercer estrategia para realizar otras pruebas:
//		////////////////////////////////////////////////////////////////////////
//
//		//Creo estrategia
//				String descripcion3="Facilitar la vida de las personas a través de la mejor experiencia digital en servicios financieros.";
//				//String vision3="Ser la compañía líder en soluciones de tecnología para la banca digital en el mercado global.";
//				estrategiaService.addEstrategia(new Estrategia("Tesis Application", descripcion3));
//
//				//Creo perspectivas
//				perspectivaService.addPerspectiva(new Perspectiva("Financiera", "Descripcion financiera..."));
//				perspectivaService.addPerspectiva(new Perspectiva("Clientes", "Descripcion clientes..."));
//				perspectivaService.addPerspectiva(new Perspectiva("Procesos internos", "Descripcion procesos internos..."));
//				perspectivaService.addPerspectiva(new Perspectiva("Aprendizaje y crecimiento", "Descripcion aprendizaje y crecimiento..."));
//
//				//Creo objetivos
//				objetivoService.addObjetivo(new Objetivo("Utilidades","Descripcion utilidades..."));
//				objetivoService.addObjetivo(new Objetivo("Ingresos","Descripcion ingresos..."));
//				objetivoService.addObjetivo(new Objetivo("Capitalizacion","Descripcion capitalizacion..."));
//				objetivoService.addObjetivo(new Objetivo("Posicionamiento en el mercado","Descripcion Posicionamiento en el mercado..."));
//				objetivoService.addObjetivo(new Objetivo("Incrementar no. clientes","Descripcion incrementar no. clientes..."));
//				objetivoService.addObjetivo(new Objetivo("Fidelizacion de clientes","Descripcion fidelizacion de clientes..."));
//				objetivoService.addObjetivo(new Objetivo("Optimizar procesos","Descripcion optimizar procesos..."));
//				objetivoService.addObjetivo(new Objetivo("Documentar nuevos desarrollos","Descripcion documentar nuevos desarrollow..."));
//				objetivoService.addObjetivo(new Objetivo("Investigar nuevas tecnologias","Descripcion investigar nuevas tecnologias..."));
//				objetivoService.addObjetivo(new Objetivo("Crecimiento profesional","Descripcion crecimiento profesional..."));
//				objetivoService.addObjetivo(new Objetivo("Traspaso funciones internas","Descripcion traspaso funciones internas..."));
//				objetivoService.addObjetivo(new Objetivo("Bienestar","Descripcion bienestar..."));
//
//				//Creo indicadores
//				indicadorService.addIndicador(new Indicador("1 i1-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("2 i1-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("3 i2-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("4 i2-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("5 i3-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("6 i3-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("7 i4-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("8 i4-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("9 i5-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("10 i5-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("11 i6-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("12 i6-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("13 i7-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("14 i7-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("15 i8-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("16 i8-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("17 i9-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("18 i9-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("19 i10-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("20 i10-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("21 i11-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("22 i11-B", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("23 i12-A", nroRandomDIEZ()));
//				indicadorService.addIndicador(new Indicador("24 i12-B", nroRandomDIEZ()));
//
//				//Relaciono las perspectivas-estrategias
//				estrategiaService.addPerspectivaAfectante(3, perspectivaService.getPerspectiva(9));
//				estrategiaService.addPerspectivaAfectante(3, perspectivaService.getPerspectiva(10));
//				estrategiaService.addPerspectivaAfectante(3, perspectivaService.getPerspectiva(11));
//				estrategiaService.addPerspectivaAfectante(3, perspectivaService.getPerspectiva(12));
//
//				//Relaciono los objetivos-perspectivas
//				perspectivaService.addObjetivoAfectante(9, objetivoService.getObjetivo(20));
//				perspectivaService.addObjetivoAfectante(9, objetivoService.getObjetivo(21));
//				perspectivaService.addObjetivoAfectante(9, objetivoService.getObjetivo(22));
//				perspectivaService.addObjetivoAfectante(10, objetivoService.getObjetivo(23));
//				perspectivaService.addObjetivoAfectante(10, objetivoService.getObjetivo(24));
//				perspectivaService.addObjetivoAfectante(10, objetivoService.getObjetivo(25));
//				perspectivaService.addObjetivoAfectante(11, objetivoService.getObjetivo(26));
//				perspectivaService.addObjetivoAfectante(11, objetivoService.getObjetivo(27));
//				perspectivaService.addObjetivoAfectante(11, objetivoService.getObjetivo(28));
//				perspectivaService.addObjetivoAfectante(12, objetivoService.getObjetivo(29));
//				perspectivaService.addObjetivoAfectante(12, objetivoService.getObjetivo(30));
//				perspectivaService.addObjetivoAfectante(12, objetivoService.getObjetivo(31));
//
//
//				//Relaciono los objetivos-objetivos
//				//Los objetivos 10 y 12 no tienen dependencias
//				objetivoService.addObjetivoAfectante(20,23);
//				objetivoService.addObjetivoAfectante(21,20);
//				objetivoService.addObjetivoAfectante(21,22);
//				objetivoService.addObjetivoAfectante(21,24);
//				objetivoService.addObjetivoAfectante(22,25);
//				objetivoService.addObjetivoAfectante(23,26);
//				objetivoService.addObjetivoAfectante(24,27);
//				objetivoService.addObjetivoAfectante(25,28);
//				objetivoService.addObjetivoAfectante(26,30);
//				objetivoService.addObjetivoAfectante(27,30);
//				objetivoService.addObjetivoAfectante(27,29);
//				objetivoService.addObjetivoAfectante(28,31);
//				objetivoService.addObjetivoAfectante(30,31);
//
//
////				//Relaciono los indicadores-objetivos
//				objetivoService.addIndicadorAfectante(20, 1, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(20, 2, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(21, 3, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(21, 4, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(22, 5, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(22, 6, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(23, 7, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(23, 8, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(24, 9, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(24, 10, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(25, 11, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(25, 12, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(26, 13, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(26, 14, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(27, 15, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(27, 16, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(28, 17, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(28, 18, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(29, 19, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(29, 20, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(30, 21, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(30, 22, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(31, 23, nroRandomUNO());
//				objetivoService.addIndicadorAfectante(31, 24, nroRandomUNO());
//				
				
				indicadorService.addIndicador(new Indicador("% presentación a exámenes", 6.91f));
				indicadorService.addIndicador(new Indicador("% aprobados por año", 4.7f));
				indicadorService.addIndicador(new Indicador("promedio de notas por año", 9.58f));
				indicadorService.addIndicador(new Indicador("promedio de notas por alumno", 6.65f));
				indicadorService.addIndicador(new Indicador("# ingresantes por año", 8.2f));
				indicadorService.addIndicador(new Indicador("% deserción por año", 3.4f));
				indicadorService.addIndicador(new Indicador("# alumnos con tutores", 3.3f));
				indicadorService.addIndicador(new Indicador("# tutores", 9.32f));
				indicadorService.addIndicador(new Indicador("% asistencia a cursadas", 5.8f));
				indicadorService.addIndicador(new Indicador("# temas dictados por cátedra", 6.0f));
				indicadorService.addIndicador(new Indicador("resultados de las encuestas", 4.8f));
				indicadorService.addIndicador(new Indicador("# actividades por año", 2.2f));
				indicadorService.addIndicador(new Indicador("# participantes", 4.9f));
				indicadorService.addIndicador(new Indicador("resultados de encuestas de participantes", 7.9f));
				indicadorService.addIndicador(new Indicador("# alumnos interesados en talleres", 4.14f));
				indicadorService.addIndicador(new Indicador("# talleres por año", 1.6f));

				//Creo estrategia
				String descripcion="Disminuir la deserción temprana de los alumnos de la carrera Ingeniería de Sistemas de UNICEN.";
				estrategiaService.addEstrategia(new Estrategia("Caso de estudio", descripcion));
				
		
//				//Creo perspectivas
				perspectivaService.addPerspectiva(new Perspectiva("General", "Esta perspectiva tiene un propósito general de agrupamiento."));
		
				//Creo objetivos
				objetivoService.addObjetivo(new Objetivo("Disminuir la deserción temprana","Reducir la cantidad de alumnos que abandonan la carrera Ingeniería de Sistemas en primer y segundo año."));
				objetivoService.addObjetivo(new Objetivo("Mejorar el rendimiento académico","Incrementar el promedio académico de los alumnos de Ingeniería de Sistemas."));
				objetivoService.addObjetivo(new Objetivo("Mejorar la inserción académica","Incrementar el porcentaje de alumnos ingresantes y re-ingresantes, de la carrera Ingeniería de Sistemas."));
				objetivoService.addObjetivo(new Objetivo("Implementar sistemas de tutorías","Lograr llevar a cabo sistemas de tutorías para el apoyo de los alumnos de Ingeniería de Sistemas en primer y segundo año."));
				objetivoService.addObjetivo(new Objetivo("Mejorar la “calidad” de las cátedras","Acrecentar el nivel de enseñanza de las clases. "));
				objetivoService.addObjetivo(new Objetivo("Desarrollar actividades de integración y sociabilización","Implementar actividades para expandir las fronteras de los alumnos."));
				objetivoService.addObjetivo(new Objetivo("Desarrollar talleres de relaciones institucionales","Implementar oportunidades de intercambio estudiantiles entre las diferentes instituciones de la universidad."));
//			
		
//				//Relaciono las perspectivas-estrategias
				estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(1));
				
		
//				//Relaciono los objetivos-perspectivas
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(1));
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(2));
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(3));
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(4));
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(5));
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(6));
				perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(7));

		
//				//Relaciono los objetivos-objetivos
//				//Los objetivos 10 y 12 no tienen dependencias
				objetivoService.addObjetivoAfectante(1,2);
				objetivoService.addObjetivoAfectante(1,3);
				objetivoService.addObjetivoAfectante(2,4);
				objetivoService.addObjetivoAfectante(2,5);
				objetivoService.addObjetivoAfectante(3,6);
				objetivoService.addObjetivoAfectante(3,7);

		
//				//Relaciono los indicadores-objetivos
				objetivoService.addIndicadorAfectante(1, 1, 3.0f);
				objetivoService.addIndicadorAfectante(1, 2, 4.0f);
				objetivoService.addIndicadorAfectante(2, 3, 5.0f);
				objetivoService.addIndicadorAfectante(2, 4, 2.0f);
				objetivoService.addIndicadorAfectante(3, 5, 4.0f);
				objetivoService.addIndicadorAfectante(3, 6, 5.0f);
				objetivoService.addIndicadorAfectante(4, 7, 1.0f);
				objetivoService.addIndicadorAfectante(4, 8, 5.0f);
				objetivoService.addIndicadorAfectante(5, 9, 4.0f);
				objetivoService.addIndicadorAfectante(5, 2, 2.0f);
				objetivoService.addIndicadorAfectante(5, 10, 3.0f);
				objetivoService.addIndicadorAfectante(5, 11, 4.0f);
				objetivoService.addIndicadorAfectante(6, 12, 3.0f);
				objetivoService.addIndicadorAfectante(6, 13, 5.0f);
				objetivoService.addIndicadorAfectante(6, 14, 3.0f);
				objetivoService.addIndicadorAfectante(7, 15, 2.0f);
				objetivoService.addIndicadorAfectante(7, 16, 5.0f);

	}

	public static Float nroRandomDIEZ() {
		return new Random().nextFloat()*10;
	}


	public static Float nroRandomUNO() {
		int min = 1;
		int max = 5;
		int val = ThreadLocalRandom.current().nextInt(min, max + 1);
		if (val == 1)
			return 1.0f;
		if (val == 2)
			return 2.0f;
		if (val == 3)
			return 3.0f;
		if (val == 4)
			return 4.0f;
		if (val == 5)
			return 5.0f;
		return 100.0f;
//		return new Random().nextFloat(); no se como sacarle los ultimos dos digitos.
	}
	
	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {
	 
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
	}
}
