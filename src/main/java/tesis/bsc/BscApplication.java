package tesis.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tesis.bsc.model.Indicador;
import tesis.bsc.service.IndicadorService;

@SpringBootApplication
public class BscApplication implements CommandLineRunner{

	@Autowired
	IndicadorService indicadorService;

	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Indicadores del caso de estudio
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
