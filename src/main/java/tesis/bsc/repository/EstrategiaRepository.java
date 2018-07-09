package tesis.bsc.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tesis.bsc.model.Estrategia;

@RepositoryRestResource(collectionResourceRel = "estrategias", path="estrategias")
public interface EstrategiaRepository extends JpaRepository<Estrategia, Integer> {
	
	List<Estrategia> findByNombre(@Param("nombre") String nombre);
	List<Estrategia> findByNombreAndMision(@Param("nombre") String nombre, @Param("vision") String vision);
}