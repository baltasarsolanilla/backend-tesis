package tesis.bsc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import tesis.bsc.model.Estrategia;


public interface EstrategiaRepository extends JpaRepository<Estrategia, Integer> {
	
	List<Estrategia> findByNombre(@Param("nombre") String nombre);
	List<Estrategia> findByNombreAndMision(@Param("nombre") String nombre, @Param("vision") String vision);
}