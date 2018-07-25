package tesis.bsc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Perspectiva {
	
	private static final String PERSPECTIVA = "perspectiva";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	 
	private String nombre;
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "perspectiva_id")
	private List<Objetivo> objetivosAfectantes;
	
	public Perspectiva() { //JPA only (for Reflection)
		
	}

	public Perspectiva(String nombre, String descripcion) {
		this.objetivosAfectantes = new ArrayList<>();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	public boolean addObjetivo(Objetivo o) {
		return this.objetivosAfectantes.add(o);
	}
	
	public boolean removeObjetivo(Objetivo o) {
		return this.objetivosAfectantes.remove(o);
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perspectiva )) return false;
        return this.id != null && this.id.equals(((Perspectiva) o).getId());
    }
	

    @Override
    public int hashCode() {
        return PERSPECTIVA.hashCode();
    }
    
	public Perspectiva clonePerspectiva() {
		Perspectiva p_clone = new Perspectiva();
		p_clone.setId(this.getId());
		p_clone.setNombre(this.getNombre());
		p_clone.setDescripcion(this.getDescripcion());
		return p_clone;
	}
	
}