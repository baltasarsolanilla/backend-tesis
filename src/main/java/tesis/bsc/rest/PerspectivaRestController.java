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
import tesis.bsc.model.Perspectiva;
import tesis.bsc.repository.ObjetivoRepository;
import tesis.bsc.repository.PerspectivaRepository;

@RestController
@RequestMapping("perspectivas")
public class PerspectivaRestController {
	
	@Autowired
	private PerspectivaRepository perspectivaRepository;
	
	@Autowired
	private ObjetivoRepository objetivoRepository;
	
	/*
	 * PATH: /perspectivas
	 */
	
	//Get all Perspectivas
	@GetMapping
    public Collection<Perspectiva> findAllPerspectivas() {
        return ((Collection<Perspectiva>) perspectivaRepository.findAll());
        
    }
	
	//Create Perspectiva
	@PostMapping
	public Perspectiva addPerspectiva(@RequestBody Perspectiva perspectiva) {
	    perspectivaRepository.save(perspectiva);
	    return perspectiva;
	}
	
	/*
	 * PATH: /perspectivas/{idPerspectiva}
	 */
	
	//Get Perspectiva by ID
	@GetMapping(path="/{idPerspectiva}")
	public Perspectiva getPerspectiva(@PathVariable("idPerspectiva") int id) {
		Perspectiva perspectiva = perspectivaRepository.findById(id).orElse(null);
		return perspectiva;
	}
	
	//Update Perspectiva by ID
	@PutMapping(path="/{idPerspectiva}")
	public Perspectiva updatePerspectiva(@PathVariable("idPerspectiva") int id, @RequestBody Perspectiva perspectiva) {
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		p.setNombre(perspectiva.getNombre());
		p.setDescripcion(perspectiva.getDescripcion());
		return perspectivaRepository.save(p);		
	}
	
	//Delete Perspectiva by ID
	@DeleteMapping(path="{idPerspectiva}")
	public Perspectiva deletePerspectiva(@PathVariable("idPerspectiva") int id) {
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		Perspectiva perspectivaEliminada = p.clonePerspectiva();
		perspectivaRepository.delete(p);
		return perspectivaEliminada;
	} 
	
	/*
	 * PATH: /perspectivas/{idPerspectiva}/objetivosAfectantes
	 */
	
	//Get all objetivosAfectantes
	@GetMapping(path = "/{idPerspectiva}/objetivosAfectantes")
	public Collection<Objetivo> getObjetivosAfectantes(@PathVariable("idPerspectiva") int id){
		Perspectiva perspectiva = perspectivaRepository.findById(id).orElse(null);
		return perspectiva.getObjetivosAfectantes();
	}
	
	//Add Objetivo to objetivosAfectantes by ID
	@PostMapping(path = "/{idPerspectiva}/objetivosAfectantes")
	public Collection<Objetivo> addObjetivosAfectantes(@PathVariable("idPerspectiva") int id, @RequestBody Objetivo objetivo) {
		Perspectiva perspectiva = perspectivaRepository.findById(id).orElse(null);
		perspectiva.addObjetivo(objetivo);
		perspectivaRepository.save(perspectiva);
		return perspectiva.getObjetivosAfectantes();
	}
	
	//Delete Objetivo from objetivosAfectantes by ID
	@DeleteMapping(path = "/{idPerspectiva}/objetivosAfectantes")
	public Collection<Objetivo> deleteObjetivosAfectantes(@PathVariable("idPerspectiva") int id, @RequestBody Objetivo objetivo) {
		Perspectiva perspectiva = perspectivaRepository.findById(id).orElse(null);
		Objetivo objetivoAfectante = objetivoRepository.findById(objetivo.getId()).orElse(null);
		perspectiva.removeObjetivo(objetivoAfectante);
		perspectivaRepository.save(perspectiva);
		return perspectiva.getObjetivosAfectantes();
	}

}
