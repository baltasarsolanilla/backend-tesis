package tesis.bsc.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.repository.IndicadorRepository;


@RestController
@RequestMapping("indicadores")
public class IndicadorRestController {
	
	@Autowired
	IndicadorRepository indicadorRepository;
	
	
	@GetMapping
	public Collection<Indicador> findAllIndicadores(){
		return indicadorRepository.findAll();
	}
	
	//Create Objetivo -- TEST PURPOSE ONLY
	@PostMapping
	public Indicador addIndicador(@RequestBody Indicador indicador) {
		return indicadorRepository.save(indicador);
	}
	
	//Update Indicador by ID
	@PutMapping(path="/{idIndicador}")
	public Indicador updateIndicador(@PathVariable("idIndicador") int id, @RequestBody Indicador indicador) {
		Indicador i = indicadorRepository.findById(id).orElse(null);
		i.setNombre(indicador.getNombre());
		i.setValor(indicador.getValor());
		return indicadorRepository.save(i);			
	}

}
