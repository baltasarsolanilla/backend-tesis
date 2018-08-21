package tesis.bsc.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tesis.bsc.model.Indicador;
import tesis.bsc.repository.IndicadorRepository;
import tesis.bsc.service.IndicadorService;


@RestController
@RequestMapping("indicadores")
public class IndicadorRestController {
	
	@Autowired
	IndicadorRepository indicadorRepository;
	
	@Autowired
	IndicadorService indicadorService;
	
	/*
	 * PATH: /indicadores
	 */
	
	//Get all Indicadores -- TEST PURPOSE ONLY
	@GetMapping
	public Collection<Indicador> findAllIndicadores(){
		return indicadorService.findAllIndicadores();
	}
	
	//Create Indicador -- TEST PURPOSE ONLY
	@PostMapping
	public Indicador addIndicador(@RequestBody Indicador indicador) {
		return indicadorService.addIndicador(indicador);
	}
	
	/*
	 * PATH: /indicadores/{idIndicador} 
	 */
	
	//Update Indicador by ID -- TEST PURPOSE ONLY
	@PutMapping(path="/{idIndicador}")
	public Indicador updateIndicador(@PathVariable("idIndicador") int id, @RequestBody Indicador indicador) {
		return indicadorService.updateIndicador(id, indicador);
	}
	
	//Delete Indicador by ID -- TEST PURPOSE ONLY
	@DeleteMapping(path="/{idIndicador}")
	public void deleteIndicador(@PathVariable("idIndicador") int id) {
		indicadorService.deleteIndicador(id);
	}

}
