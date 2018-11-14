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

import tesis.bsc.model.Estrategia;
import tesis.bsc.model.Perspectiva;
import tesis.bsc.service.EstrategiaService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("estrategias")
public class EstrategiaRestController {
	
	@Autowired
	private EstrategiaService estrategiaService;
	
	/*
	 * PATH: /estrategias
	 */
	
	//Get all Estrategias
	@GetMapping
    public Collection<Estrategia> findAllEstrategias() {
        return estrategiaService.findAllEstrategias();
        
    }
	
	//Create Estrategia
	@PostMapping
	public Estrategia addEstrategia(@RequestBody Estrategia estrategia) {
	    return estrategiaService.addEstrategia(estrategia);
	}
	
	/*
	 * PATH: /estrategias/{idEstrategia}
	 */
	
	//Get ESTRATEGIA by ID
	@GetMapping(path="/{idEstrategia}")
	public Estrategia getEstrategia(@PathVariable("idEstrategia") int id) {
		return estrategiaService.getEstrategia(id);
	}
	
	//Update Estrategia by ID
	@PutMapping(path="/{idEstrategia}")
	public Estrategia updateEstrategia(@PathVariable("idEstrategia") int id, @RequestBody Estrategia estrategia) {
		return estrategiaService.updateEstrategia(id, estrategia);			
	}
	
	//Delete Estrategia by ID
	@DeleteMapping(path="{idEstrategia}")
	public void deleteEstrategia(@PathVariable("idEstrategia") int id) {
		estrategiaService.deleteEstrategia(id);
	} 
	
	/*
	 * PATH: /estrategias/{idEstrategia}/perspectivasAfectantes
	 */
	
	//Get all perspectivasAfectantes
	@GetMapping(path = "/{idEstrategia}/perspectivasAfectantes")
	public Collection<Perspectiva> getPerspectivasAfectantes(@PathVariable("idEstrategia") int id){
		return estrategiaService.getPerspectivasAfectantes(id);
		
	}
	
	//Add Perspectiva to perspectivasAfectantes by ID
	@PostMapping(path = "/{idEstrategia}/perspectivasAfectantes")
	public Estrategia addPerspectivaAfectante(@PathVariable("idEstrategia") int id, @RequestBody Perspectiva perspectiva) {
		return estrategiaService.addPerspectivaAfectante(id, perspectiva);
	}
	
	//Delete Perspectiva from perspectivasAfectantes by ID
	//Utiliza PUT ya que lo que realmente hace es modificar la lista de perspectivasAfectante y NO eliminar el recurso asociado a la URI
	@PutMapping(path = "/{idEstrategia}/perspectivasAfectantes")
	public void deletePerspectivaAfectante(@PathVariable("idEstrategia") int id, @RequestBody Perspectiva perspectiva) {
		estrategiaService.deletePerspectivaAfectante(id, perspectiva);
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
