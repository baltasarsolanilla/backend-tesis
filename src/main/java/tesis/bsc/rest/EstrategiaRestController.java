package tesis.bsc.rest;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Autowired PerspectivaRepository perspectivaRepository;

	
	@GetMapping("/")
    public Collection<Estrategia> coolEstrategias() {
        return ((Collection<Estrategia>) estrategiaRepository.findAll());
        
    }
	
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public void addMember(@RequestBody Estrategia estrategia) {
	    estrategiaRepository.save(estrategia);
	}
	
	@PostMapping(path = "/{id}/perspectivasAsociadas", consumes = "application/json", produces = "application/json")
	public void addMember(@PathVariable("id") int id, @RequestBody Perspectiva perspectiva) {
		Estrategia estrategia = estrategiaRepository.findById(id).orElse(null);
		Perspectiva p = perspectivaRepository.findById(perspectiva.getId()).orElse(null);
		
		if (estrategia != null) {
			estrategia.addPerspectiva(perspectiva);
			estrategiaRepository.save(estrategia);
		}
	}
	
	
	
//	@DeleteMapping and @PatchMapping.
}
