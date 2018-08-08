package tesis.bsc.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.IndicadorXObjetivo;
import tesis.bsc.model.Objetivo;
import tesis.bsc.model.ObjetivoXObjetivo;
import tesis.bsc.repository.IndicadorRepository;
import tesis.bsc.repository.ObjetivoRepository;

@Service("ObjetivoService")
@Transactional
public class ObjetivoService {
	
	@Autowired
	ObjetivoRepository objetivoRepository;
	
	@Autowired
	IndicadorRepository indicadorRepository;
	
	public List<Objetivo> findAllObjetivos(){
		return objetivoRepository.findAll();
	}
	
	public Objetivo addObjetivo(Objetivo o) {
		return objetivoRepository.save(o);
	}
	
	public Objetivo getObjetivo(Integer id) {
		return objetivoRepository.findById(id).orElse(null);
	}
	
	public Objetivo updateObjetivo(Integer id, Objetivo objetivo) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		o.setNombre(objetivo.getNombre());
		o.setDescripcion(objetivo.getDescripcion());
		return objetivoRepository.save(o);
	}
	
	public void deleteObjetivo(Integer id) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		objetivoRepository.delete(o);
	}
	
	/*
	 * IndicadoresAfectantes
	 */
	
	public List<IndicadorXObjetivo> getIndicadoresAfectantes(Integer id){
		return objetivoRepository.findById(id).orElse(null).getIndicadoresAfectantes();
	}
	
	public Objetivo addIndicadorAfectante(Integer id, Integer indicadorId, Float peso ) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		Indicador i = indicadorRepository.findById(indicadorId).orElse(null);
		o.addIndicador(i, peso);
		return o;
	}
	
	public Objetivo deleteIndicadorAfectante(Integer id, Indicador i) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		o.removeIndicador(i);
		return o;
	}
	
	/*
	 * ObjetivosAfectantes
	 */
	
	public List<ObjetivoXObjetivo> getObjetivosAfectantes(Integer id){
		return objetivoRepository.findById(id).orElse(null).getObjetivosAfectantes(); 
	}
	
	public Objetivo addObjetivoAfectante(Integer id, Integer idObjetivoAfectante, Float peso) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		Objetivo objetivoAfectante = objetivoRepository.findById(idObjetivoAfectante).orElse(null);
		o.addObjetivo(objetivoAfectante, peso);
		return objetivoRepository.save(o);
	}
	
	public Objetivo deleteObjetivoAfectante(Integer id, Objetivo objetivoAfectante) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		o.removeObjetivo(objetivoAfectante);
		return objetivoRepository.save(o);
	}
}
