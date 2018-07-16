package tesis.bsc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
public @Data class Objetivo {
	
	private static final String OBJETIVO = "objetivo"; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	
	public Objetivo() { //JPA only
    }
	
	public Objetivo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Objetivo )) return false;
        return this.id != null && this.id.equals(((Objetivo) o).id);
    }
	
    @Override
    public int hashCode() {
        return OBJETIVO.hashCode();
    }
    
	public Objetivo cloneObjetivo() {
		Objetivo o_clone = new Objetivo();
		o_clone.setId(this.getId());
		o_clone.setNombre(this.getNombre());
		o_clone.setDescripcion(this.getDescripcion());
		return o_clone;
	}
}
