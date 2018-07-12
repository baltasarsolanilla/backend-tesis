package tesis.bsc.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import lombok.Data;

@Entity
public @Data class Estrategia {	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	private String nombre;
	private String mision;
	private String vision;
	
	@OneToMany(mappedBy = "estrategia", cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Perspectiva> perspectivasAsociadas;
	
	
	public Estrategia() { //JPA ONLY
	}
	
	public Estrategia(String nombre, String mision, String vision) {
		this.perspectivasAsociadas = new ArrayList<>();
		this.nombre = nombre;
		this.mision = mision;
		this.vision = vision;
	}
	
	public void addPerspectiva(Perspectiva perspectiva) {
		this.perspectivasAsociadas.add(perspectiva);
		perspectiva.setEstrategia(this);
	}
	
	public void removePerspectiva(Perspectiva perspectiva) {
		this.perspectivasAsociadas.remove(perspectiva);
		perspectiva.setEstrategia(null);
	}
}
