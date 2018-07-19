package tesis.bsc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.repository.ObjetivoRepository;

@Service("ObjetivoService")
@Transactional
public class ObjetivoService {
	
	@Autowired
	ObjetivoRepository objetivoRepository;
	
	public void addIndicador(Integer id, Indicador i) {
		Objetivo o = objetivoRepository.findById(id).orElse(null);
		o.addIndicador(i, 12.5F);
		objetivoRepository.save(o);
	}
	
	public void save(Objetivo o) {
		objetivoRepository.save(o);
	}
}
