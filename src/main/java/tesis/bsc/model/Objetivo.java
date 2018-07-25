package tesis.bsc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public @Data class Objetivo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndicadorXObjetivo> indicadoresAfectantes;
	
	public Objetivo() { //JPA only
    }
	
	public Objetivo(String nombre, String descripcion) {
		this.indicadoresAfectantes = new ArrayList<>();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
    
	public Objetivo cloneObjetivo() {
		Objetivo o_clone = new Objetivo();
		o_clone.setId(this.getId());
		o_clone.setNombre(this.getNombre());
		o_clone.setDescripcion(this.getDescripcion());
		return o_clone;
	}
		
	public boolean addIndicador(Indicador indicador, Float peso) {
		IndicadorXObjetivo ixo = new IndicadorXObjetivo(this, indicador, peso);
		return this.indicadoresAfectantes.add(ixo);
//		indicador.getObjetivosAsociados().add(ixo);
	}
	
	public boolean removeIndicador(Indicador indicador) {
		Iterator<IndicadorXObjetivo> iterator = this.indicadoresAfectantes.iterator();
		while (iterator.hasNext()) {
			IndicadorXObjetivo ixo = iterator.next();
			if (ixo.getObjetivo().equals(this) && ixo.getIndicador().equals(indicador)) {
				iterator.remove();
//				ixo.getIndicador().getObjetivosAsociados().remove(ixo);
				ixo.setObjetivo(null);
				ixo.setIndicador(null);
				return true;
			}
		}
		return false;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Objetivo )) return false;
        return this.id != null && this.id.equals(((Objetivo) o).getId());
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(this.nombre);
    }
}
