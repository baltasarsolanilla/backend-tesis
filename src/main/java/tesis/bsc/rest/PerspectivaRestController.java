package tesis.bsc.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import tesis.bsc.service.PerspectivaService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("perspectivas")
public class PerspectivaRestController {
	
	@Autowired
	private PerspectivaService perspectivaService;

	/*
	 * PATH: /perspectivas
	 */
	
	//Get all Perspectivas -- TEST PURPOSE ONLY
	@GetMapping
    public Collection<Perspectiva> findAllPerspectivas() {
        return perspectivaService.findAllPerspectivas();
        
    }
	
	///Create Perspectiva -- TEST PURPOSE ONLY
	@PostMapping
	public Perspectiva addPerspectiva(@RequestBody Perspectiva perspectiva) {
	    return perspectivaService.addPerspectiva(perspectiva);
	}
	
	/*
	 * PATH: /perspectivas/{idPerspectiva}
	 */
	
	//Get Perspectiva by ID
	@GetMapping(path="/{idPerspectiva}")
	public Perspectiva getPerspectiva(@PathVariable("idPerspectiva") int id) {
		return perspectivaService.getPerspectiva(id);
	}
	
	//Update Perspectiva by ID
	@PutMapping(path="/{idPerspectiva}")
	public Perspectiva updatePerspectiva(@PathVariable("idPerspectiva") int id, @RequestBody Perspectiva perspectiva) {
		return perspectivaService.updatePerspectiva(id, perspectiva);
	}
	
	//Delete Perspectiva by ID
	@DeleteMapping(path="{idPerspectiva}")
	public void deletePerspectiva(@PathVariable("idPerspectiva") int id) {
		perspectivaService.deletePerspectiva(id);
	} 
	
	/*
	 * PATH: /perspectivas/{idPerspectiva}/objetivosAfectantes
	 */
	
	//Get all objetivosAfectantes
	@GetMapping(path = "/{idPerspectiva}/objetivosAfectantes")
	public Collection<Objetivo> getObjetivosAfectantes(@PathVariable("idPerspectiva") int id){
		return perspectivaService.getObjetivosAfectantes(id);
	}
	
	//Add Objetivo to objetivosAfectantes by ID
	@PostMapping(path = "/{idPerspectiva}/objetivosAfectantes")
	public Perspectiva addObjetivosAfectantes(@PathVariable("idPerspectiva") int id, @RequestBody Objetivo objetivo) {
		return perspectivaService.addObjetivoAfectante(id, objetivo);
	}
	
	//Delete Objetivo from objetivosAfectantes by ID
	@DeleteMapping(path = "/{idPerspectiva}/objetivosAfectantes")
	public Perspectiva deleteObjetivosAfectantes(@PathVariable("idPerspectiva") int id, @RequestBody Objetivo objetivo) {
		return perspectivaService.deleteObjetivoAfectante(id, objetivo);
	}

}
