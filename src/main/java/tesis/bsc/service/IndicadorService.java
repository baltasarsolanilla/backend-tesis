package tesis.bsc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.repository.IndicadorRepository;


@Service("IndicadorService")
@Transactional
public class IndicadorService {
		
	@Autowired
	IndicadorRepository indicadorRepository;
	
	@Autowired
	ObjetivoService objetivoService;
	
	public List<Indicador> findAllIndicadores(){
		return indicadorRepository.findAll();
	}
	
	public Indicador addIndicador(Indicador i) {
		return indicadorRepository.save(i);
	}
	
	public Indicador updateIndicador(Integer id, Indicador indicador) {
		Indicador i = indicadorRepository.findById(id).orElse(null);
		i.setNombre(indicador.getNombre());
		i.setValor(indicador.getValor());
		actualizarObjetivosQueAfecto(i);
		return indicadorRepository.save(i);
	}
	
	public void actualizarObjetivosQueAfecto(Indicador i) {
		List<Objetivo> objetivosQueAfecto = indicadorRepository.findAllObjetivosQueAfectoById(i.getId());
		for (Objetivo obj : objetivosQueAfecto) {
			objetivoService.actualizarObjetivo(obj);
		}
	}

	public void deleteIndicador(int id) {
		Indicador o = indicadorRepository.findById(id).orElse(null);
		indicadorRepository.delete(o);
	}

}
