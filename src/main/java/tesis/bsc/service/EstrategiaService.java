package tesis.bsc.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.bsc.repository.EstrategiaRepository;
import tesis.bsc.model.Estrategia;
import tesis.bsc.model.Perspectiva;

@Service("EstrategiaService")
@Transactional
public class EstrategiaService {
	
	@Autowired
	EstrategiaRepository estrategiaRepository;
	
	public List<Estrategia> findAllEstrategias(){
		return estrategiaRepository.findAll();
	}
	
	public Estrategia addEstrategia(Estrategia e) {
		return estrategiaRepository.save(e);
	}
	
	public Estrategia getEstrategia(Integer id) {
		return estrategiaRepository.findById(id).orElse(null);
	}
	
	public Estrategia updateEstrategia(Integer id, Estrategia estrategia) {
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		e.setNombre(estrategia.getNombre());
		e.setDescripcion(estrategia.getDescripcion());
		return estrategiaRepository.save(e);
	}
	
	public void deleteEstrategia(Integer id) {
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		estrategiaRepository.delete(e);
	}
	
	/*
	 * PerspectivasAfectantes
	 */
	
	public List<Perspectiva> getPerspectivasAfectantes(Integer id){
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		return e.getPerspectivasAfectantes();
	}
	
	public Estrategia addPerspectivaAfectante(Integer id, Perspectiva p) {
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		e.addPerspectiva(p);
		return estrategiaRepository.save(e);
	}
	
	public Estrategia deletePerspectivaAfectante(Integer id, Perspectiva p) {
		Estrategia e = estrategiaRepository.findById(id).orElse(null);
		e.removePerspectiva(p);
		return estrategiaRepository.save(e);
	}
}
