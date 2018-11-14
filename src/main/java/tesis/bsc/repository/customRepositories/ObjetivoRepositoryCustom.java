package tesis.bsc.repository.customRepositories;

import java.time.LocalDate;
import java.util.HashSet;

import tesis.bsc.responseBodyObject.ObjetivoHistory;

public interface ObjetivoRepositoryCustom {
	public HashSet<ObjetivoHistory> findAllObjetivoRevisionByIdAndDate(Integer id, LocalDate fromDate, LocalDate toDate);
}
