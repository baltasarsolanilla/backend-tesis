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

import tesis.bsc.model.Estrategia;
import tesis.bsc.model.Perspectiva;
import tesis.bsc.repository.EstrategiaRepository;
import tesis.bsc.repository.PerspectivaRepository;

@RestController
@RequestMapping("estrategias")
public class EstrategiaRestController {
	
	@Autowired
	private EstrategiaRepository estrategiaRepository;
	
	@Autowired 
	private PerspectivaRepository perspectivaRepository;

	
	/*
	 * PATH: /estrategias
	 */
	
	//Get all Estrategias
	@GetMapping
    public Collection<Estrategia> findAllEstrategias() {
        return ((Collection<Estrategia>) estrategiaRepository.findAll());
        
    }
	
	//Create Estrategia
	@PostMapping
	public Estrategia addEstrategia(@RequestBody Estrategia estrategia) {
	    estrategiaRepository.save(estrategia);
	    return estrategia;
	}
	
	/*
	 * PATH: /estrategias/{idEstrategia}
	 */
	
	//Get ESTRATEGIA by ID
	@GetMapping(path="/{idEstrategia}")
	public Estrategia getEstrategia(@PathVariable("idEstrategia") int id) {
		Estrategia estrategia = estrategiaRepository.findById(id).orElse(null);
		return estrategia;
	}
	
	//Update Estrategia by ID
	@PutMapping(path="/{idEstrategia}")
	public Estrategia updateEstrategia(@PathVariable("idEstrategia") int id, @RequestBody Estrategia estrategia) {
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		e.setNombre(estrategia.getNombre());
		e.setMision(estrategia.getMision());
		e.setVision(estrategia.getVision());
		return estrategiaRepository.save(e);		
	}
	
	//Delete Estrategia by ID
	@DeleteMapping(path="{idEstrategia}")
	public Estrategia deleteEstrategia(@PathVariable("idEstrategia") int id) {
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		Estrategia estrategiaEliminada = e.cloneEstrategia();
		estrategiaRepository.delete(e);
		return estrategiaEliminada;
	} 
	
	/*
	 * PATH: /estrategias/{idEstrategia}/perspectivasAfectantes
	 */
	
	//Get all perspectivasAfectantes
	@GetMapping(path = "/{idEstrategia}/perspectivasAfectantes")
	public Collection<Perspectiva> getPerspectivasAfectantes(@PathVariable("idEstrategia") int id){
		Estrategia estrategia = estrategiaRepository.findById(id).orElse(null);
		return estrategia.getPerspectivasAfectantes();
	}
	
	//Add Perspectiva to perspectivasAfectantes by ID
	@PostMapping(path = "/{idEstrategia}/perspectivasAfectantes")
	public Collection<Perspectiva> addPerspectivaAfectante(@PathVariable("idEstrategia") int id, @RequestBody Perspectiva perspectiva) {
		Estrategia estrategia = estrategiaRepository.findById(id).orElse(null);
		estrategia.addPerspectiva(perspectiva);
		estrategiaRepository.save(estrategia);
		return estrategia.getPerspectivasAfectantes();
	}
	
	//Delete Perspectiva from perspectivasAfectantes by ID
	@DeleteMapping(path = "/{idEstrategia}/perspectivasAfectantes")
	public Collection<Perspectiva> deletePerspectivaAfectante(@PathVariable("idEstrategia") int id, @RequestBody Perspectiva perspectiva) {
		Estrategia estrategia = estrategiaRepository.findById(id).orElse(null);
		Perspectiva perspectivaAfectante = perspectivaRepository.findById(perspectiva.getId()).orElse(null);
		estrategia.removePerspectiva(perspectivaAfectante);
		estrategiaRepository.save(estrategia);
		return estrategia.getPerspectivasAfectantes();
	}
	
	
	
	/*
	 * CHANCHADA POR LAS CHAUCHAS
	 */
	
	
//	@DeleteMapping(path = ""
	
//	HttpHeaders headers = new HttpHeaders();
//    headers.setLocation(ucBuilder.path("/Objetivo/{name}").buildAndExpand(objetivo.getName()).toUri());
//    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
// @PostMapping(consumes = "application/json", produces = "application/json")
//	@DeleteMapping and @PatchMapping.
}
