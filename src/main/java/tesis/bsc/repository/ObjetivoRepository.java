package tesis.bsc.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.Objetivo;
import tesis.bsc.model.ObjetivoXObjetivo;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {
	
	 @Query("SELECT i FROM Indicador i WHERE i.id = :id") 
	 Indicador findIndicadorEnObjetivo(@Param("id") Integer id);
	 
	 @Query("SELECT oxo FROM ObjetivoXObjetivo oxo WHERE oxo.id.objetivoId = :id")
	 List<ObjetivoXObjetivo> findObjetivosXObjetivosById(@Param("id") Integer id);
	 
	 @Query("SELECT oxo FROM ObjetivoXObjetivo oxo WHERE oxo.id.objetivoAfectanteId = :id")
	 List<ObjetivoXObjetivo> findObjetivosXObjetivosQueAfectoById(@Param("id") Integer id); 
	 
	 @Query("SELECT o FROM Objetivo o WHERE o.id = :id")
	 Objetivo findObjetivoByIdentificador(@Param("id") Integer id);
}
