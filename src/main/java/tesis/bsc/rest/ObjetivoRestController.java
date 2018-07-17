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

import tesis.bsc.model.Objetivo;
import tesis.bsc.repository.ObjetivoRepository;

@RestController
@RequestMapping("objetivos")
public class ObjetivoRestController {
	
	@Autowired
	private ObjetivoRepository objetivoRepository;
	
	/*
	 * PATH: /objetivos
	 */
	
	//Get all Objetivos -- TEST PURPOSE ONLY
	@GetMapping
	public Collection<Objetivo> findAllObjetivos(){
		return (Collection<Objetivo>) objetivoRepository.findAll();
	}
	
	//Create Objetivo -- TEST PURPOSE ONLY
	@PostMapping
	public Objetivo addObjetivo(@RequestBody Objetivo objetivo) {
		objetivoRepository.save(objetivo);
		return objetivo;
	}

	/*
	 * PATH: /objetivos/{idObjetivo}
	 */
	
	//Get Objetivo by ID
	@GetMapping(path="/{idObjetivo}")
	public Objetivo getObjetivo(@PathVariable("idObjetivo") int id) {
		Objetivo objetivo = objetivoRepository.findById(id).orElse(null);
		return objetivo;
	}
	
	//Update Objetivo by ID
	@PutMapping(path="/{idObjetivo}")
	public Objetivo updateObjetivo(@PathVariable("idObjetivo") int id, @RequestBody Objetivo objetivo) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		o.setNombre(objetivo.getNombre());
		o.setDescripcion(objetivo.getDescripcion());
		return objetivoRepository.save(o);		
	}
	
	//Delete Objetivo by ID
	@DeleteMapping(path="{idObjetivo}")
	public Objetivo deleteObjetivo(@PathVariable("idObjetivo") int id) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		Objetivo objetivoEliminado = o.cloneObjetivo();
		objetivoRepository.delete(o);
		return objetivoEliminado;
	} 
}
