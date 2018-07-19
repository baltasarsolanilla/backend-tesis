package tesis.bsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tesis.bsc.model.Indicador;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Integer> {

}
