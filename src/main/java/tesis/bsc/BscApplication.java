package tesis.bsc;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		String mision="Facilitar la vida de las personas a través de la mejor experiencia digital en servicios financieros.";
		String vision="Ser la compañía líder en soluciones de tecnología para la banca digital en el mercado global.";
		estrategiaService.addEstrategia(new Estrategia("Technisys RQT", mision, vision));
		
		//Creo perspectivas
		perspectivaService.addPerspectiva(new Perspectiva("1 Financiera", "Descripcion financiera..."));		
		perspectivaService.addPerspectiva(new Perspectiva("2 Clientes", "Descripcion clientes..."));
		perspectivaService.addPerspectiva(new Perspectiva("3 Procesos internos", "Descripcion procesos internos..."));
		perspectivaService.addPerspectiva(new Perspectiva("4 Aprendizaje y crecimiento", "Descripcion aprendizaje y crecimiento..."));
		
		//Creo objetivos
		objetivoService.addObjetivo(new Objetivo("1 Ingresos","Descripcion ingresos..."));
		objetivoService.addObjetivo(new Objetivo("2 Utilidades","Descripcion utilidades..."));
		objetivoService.addObjetivo(new Objetivo("3 Capitalizacion","Descripcion capitalizacion..."));
		objetivoService.addObjetivo(new Objetivo("4 Posicionamiento en el mercado","Descripcion Posicionamiento en el mercado..."));
		objetivoService.addObjetivo(new Objetivo("5 Incrementar no. clientes","Descripcion incrementar no. clientes..."));
		objetivoService.addObjetivo(new Objetivo("6 Fidelizacion de clientes","Descripcion fidelizacion de clientes..."));
		objetivoService.addObjetivo(new Objetivo("7 Optimizar procesos","Descripcion optimizar procesos..."));
		objetivoService.addObjetivo(new Objetivo("8 Documentar nuevos desarrollow","Descripcion documentar nuevos desarrollow..."));
		objetivoService.addObjetivo(new Objetivo("9 Investigar nuevas tecnologias","Descripcion investigar nuevas tecnologias..."));
		objetivoService.addObjetivo(new Objetivo("10 Crecimiento profesional","Descripcion crecimiento profesional..."));
		objetivoService.addObjetivo(new Objetivo("11 Traspaso funciones internas","Descripcion traspaso funciones internas..."));
		objetivoService.addObjetivo(new Objetivo("12 Bienestar","Descripcion bienestar..."));		
		
		//Creo indicadores
		indicadorService.addIndicador(new Indicador("1 i1-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("2 i1-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("3 i2-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("4 i2-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("5 i3-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("6 i3-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("7 i4-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("8 i4-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("9 i5-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("10 i5-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("11 i6-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("12 i6-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("13 i7-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("14 i7-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("15 i8-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("16 i8-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("17 i9-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("18 i9-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("19 i10-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("20 i10-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("21 i11-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("22 i11-B", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("23 i12-A", nroRandomDIEZ()));
		indicadorService.addIndicador(new Indicador("24 i12-B", nroRandomDIEZ()));
		
		//Relaciono las perspectivas-estrategias
		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(1));
		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(2));
		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(3));
		estrategiaService.addPerspectivaAfectante(1, perspectivaService.getPerspectiva(4));
		
		//Relaciono los objetivos-perspectivas
		perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(1));
		perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(2));
		perspectivaService.addObjetivoAfectante(1, objetivoService.getObjetivo(3));
		perspectivaService.addObjetivoAfectante(2, objetivoService.getObjetivo(4));
		perspectivaService.addObjetivoAfectante(2, objetivoService.getObjetivo(5));
		perspectivaService.addObjetivoAfectante(2, objetivoService.getObjetivo(6));
		perspectivaService.addObjetivoAfectante(3, objetivoService.getObjetivo(7));
		perspectivaService.addObjetivoAfectante(3, objetivoService.getObjetivo(8));
		perspectivaService.addObjetivoAfectante(3, objetivoService.getObjetivo(9));
		perspectivaService.addObjetivoAfectante(4, objetivoService.getObjetivo(10));
		perspectivaService.addObjetivoAfectante(4, objetivoService.getObjetivo(11));
		perspectivaService.addObjetivoAfectante(4, objetivoService.getObjetivo(12));
		
		
		//Relaciono los objetivos-objetivos
		//Los objetivos 10 y 12 no tienen dependencias
		objetivoService.addObjetivoAfectante(1,2, nroRandomUNO());
		objetivoService.addObjetivoAfectante(1,3, nroRandomUNO());
		objetivoService.addObjetivoAfectante(2,4, nroRandomUNO());
		objetivoService.addObjetivoAfectante(3,6, nroRandomUNO());
		objetivoService.addObjetivoAfectante(4,7, nroRandomUNO());
		objetivoService.addObjetivoAfectante(5,8, nroRandomUNO());
		objetivoService.addObjetivoAfectante(6,9, nroRandomUNO());
		objetivoService.addObjetivoAfectante(7,11, nroRandomUNO());
		objetivoService.addObjetivoAfectante(8,11, nroRandomUNO());
		objetivoService.addObjetivoAfectante(9,12, nroRandomUNO());
		objetivoService.addObjetivoAfectante(11,12, nroRandomUNO());
		
		
		//Relaciono los indicadores-objetivos
		objetivoService.addIndicadorAfectante(1, 1, nroRandomUNO());
		objetivoService.addIndicadorAfectante(1, 2, nroRandomUNO());
		objetivoService.addIndicadorAfectante(2, 3, nroRandomUNO());
		objetivoService.addIndicadorAfectante(2, 4, nroRandomUNO());
		objetivoService.addIndicadorAfectante(3, 5, nroRandomUNO());
		objetivoService.addIndicadorAfectante(3, 6, nroRandomUNO());
		objetivoService.addIndicadorAfectante(4, 7, nroRandomUNO());
		objetivoService.addIndicadorAfectante(4, 8, nroRandomUNO());
		objetivoService.addIndicadorAfectante(5, 9, nroRandomUNO());
		objetivoService.addIndicadorAfectante(5, 10, nroRandomUNO());
		objetivoService.addIndicadorAfectante(6, 11, nroRandomUNO());
		objetivoService.addIndicadorAfectante(6, 12, nroRandomUNO());
		objetivoService.addIndicadorAfectante(7, 13, nroRandomUNO());
		objetivoService.addIndicadorAfectante(7, 14, nroRandomUNO());
		objetivoService.addIndicadorAfectante(8, 15, nroRandomUNO());
		objetivoService.addIndicadorAfectante(8, 16, nroRandomUNO());
		objetivoService.addIndicadorAfectante(9, 17, nroRandomUNO());
		objetivoService.addIndicadorAfectante(9, 18, nroRandomUNO());
		objetivoService.addIndicadorAfectante(10, 19, nroRandomUNO());
		objetivoService.addIndicadorAfectante(10, 20, nroRandomUNO());
		objetivoService.addIndicadorAfectante(11, 21, nroRandomUNO());
		objetivoService.addIndicadorAfectante(11, 22, nroRandomUNO());
		objetivoService.addIndicadorAfectante(12, 23, nroRandomUNO());
		objetivoService.addIndicadorAfectante(12, 24, nroRandomUNO());

		// Do some work & in the mean time the database has been updated by a batch job

		// refresh object and now up to date

//		Objetivo oRev0 = objetivoService.findObjRevision(1, 1);
//		Objetivo oRev1 = objetivoService.findObjRevision(1, 4);
//		Objetivo oRev2 = objetivoService.findObjRevision(1, 7);
//		Objetivo oRev3 = objetivoService.findObjRevision(1, 8);
	}
	
	public static Float nroRandomDIEZ() {
		return new Random().nextFloat()*10;
	}
	
	public static Float nroRandomUNO() {
		return new Random().nextFloat();
	}
}
