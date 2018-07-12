package tesis.bsc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public @Data class Perspectiva {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	 
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estrategia_id")
	private Estrategia estrategia;
	
	private String nombre;
	private String descripcion;
	
	public Perspectiva() { //JPA only (for Reflection)
		
	}

	public Perspectiva(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perspectiva )) return false;
        return this.id != null && this.id.equals(((Perspectiva) o).id);
    }
	
    @Override
    public int hashCode() {
        return 31;
    }
	
}