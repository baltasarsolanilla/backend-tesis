package tesis.bsc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "estrategia_id")
	private List<Perspectiva> perspectivasAfectantes;
	
	
	public Estrategia() { //JPA ONLY
	}
	
	public Estrategia(String nombre, String mision, String vision) {
		this.perspectivasAfectantes = new ArrayList<>();
		this.nombre = nombre;
		this.mision = mision;
		this.vision = vision;
	}
	
	public void addPerspectiva(Perspectiva p) {
		this.perspectivasAfectantes.add(p);
	}
	
	public void removePerspectiva(Perspectiva p) {
		this.perspectivasAfectantes.remove(p);
	}
	
	public Estrategia cloneEstrategia() {
		Estrategia e_clone = new Estrategia();
		e_clone.setId(this.getId());
		e_clone.setNombre(this.getNombre());
		e_clone.setMision(this.getMision());
		e_clone.setVision(this.getVision());
		return e_clone;
	}
}
