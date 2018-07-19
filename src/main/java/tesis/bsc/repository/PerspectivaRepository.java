package tesis.bsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tesis.bsc.model.Perspectiva;


@Repository
public interface PerspectivaRepository extends JpaRepository<Perspectiva, Integer> {
	
}
