package tesis.bsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tesis.bsc.model.Objetivo;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

}
