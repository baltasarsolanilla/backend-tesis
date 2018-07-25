package tesis.bsc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tesis.bsc.model.Objetivo;
import tesis.bsc.model.Perspectiva;
import tesis.bsc.repository.PerspectivaRepository;

@Service("PerspectivaService")
@Transactional
public class PerspectivaService {
	
	@Autowired
	PerspectivaRepository perspectivaRepository;
	
	public List<Perspectiva> findAllPerspectivas(){
		return perspectivaRepository.findAll();
	}
	
	public Perspectiva addPerspectiva(Perspectiva p) {
		return perspectivaRepository.save(p);
	}
	
	public Perspectiva getPerspectiva(Integer id) {
		return perspectivaRepository.findById(id).orElse(null);
	}
	
	public Perspectiva updatePerspectiva(Integer id, Perspectiva perspectiva) {
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		p.setNombre(perspectiva.getNombre());
		p.setDescripcion(perspectiva.getDescripcion());
		return perspectivaRepository.save(p);
	}
	
	public void deletePerspectiva(Integer id) {
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		perspectivaRepository.delete(p);
	}
	
	/*
	 * ObjetivosAfectantes
	 */
	
	public List<Objetivo> getObjetivosAfectantes(Integer id){
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		return p.getObjetivosAfectantes();
	}
	
	public Perspectiva addObjetivoAfectante(Integer id, Objetivo o){
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		p.addObjetivo(o);
		return perspectivaRepository.save(p);
	}
	
	public Perspectiva deleteObjetivoAfectante(Integer id, Objetivo o) {
		Perspectiva p = perspectivaRepository.findById(id).orElse(null);
		p.removeObjetivo(o);
		return perspectivaRepository.save(p);
	}
}

