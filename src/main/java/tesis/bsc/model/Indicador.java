package tesis.bsc.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public @Data class Indicador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	private Float valor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "indicador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndicadorXObjetivo> objetivosQueAfecto;
	
	public Indicador() { //JPA ONLY
    }
	
	public Indicador(String nombre, Float valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Indicador )) return false;
        return this.id != null && this.id.equals(((Indicador) o).getId());
    }
	
    @Override
    public int hashCode() {
        return  Objects.hash(this.id);
    }
}
