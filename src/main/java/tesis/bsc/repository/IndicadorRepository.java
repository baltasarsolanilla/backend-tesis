package tesis.bsc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Integer> {
	
	 @Query("SELECT ixo.objetivo FROM IndicadorXObjetivo ixo WHERE ixo.id.indicadorId = :id") 
	 List<Objetivo> findAllObjetivosQueAfectoById(@Param("id") Integer id);
}
