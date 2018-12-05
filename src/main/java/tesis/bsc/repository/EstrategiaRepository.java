package tesis.bsc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tesis.bsc.model.Estrategia;

@Repository
public interface EstrategiaRepository extends JpaRepository<Estrategia, Integer> {
	
	List<Estrategia> findByNombre(@Param("nombre") String nombre);
	List<Estrategia> findByNombreAndDescripcion(@Param("nombre") String nombre, @Param("descripcion") String descripcion);
}