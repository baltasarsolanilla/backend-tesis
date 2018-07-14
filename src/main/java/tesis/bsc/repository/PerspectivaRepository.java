package tesis.bsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tesis.bsc.model.Perspectiva;


public interface PerspectivaRepository extends JpaRepository<Perspectiva, Integer> {
	
}
