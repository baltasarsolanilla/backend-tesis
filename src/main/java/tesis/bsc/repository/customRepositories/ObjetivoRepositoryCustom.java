package tesis.bsc.repository.customRepositories;

import tesis.bsc.model.Objetivo;

public interface ObjetivoRepositoryCustom {
	public Objetivo findObjRevision(Integer id, Integer rev);
	
}
