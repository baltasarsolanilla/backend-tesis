package tesis.bsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tesis.bsc.model.Perspectiva;

@RepositoryRestResource(collectionResourceRel = "perspectivas", path="perspectivas")
public interface PerspectivaRepository extends JpaRepository<Perspectiva, Integer> {
	
}
