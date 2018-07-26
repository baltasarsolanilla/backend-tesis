package tesis.bsc.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public @Data class ObjetivoXObjetivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ObjetivoXObjetivoId id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("objetivoId")
	private Objetivo objetivo;
	
		
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("objetivoAfectanteId")
	private Objetivo objetivoAfectante;


	private Float peso;
	
	
	public ObjetivoXObjetivo() { //JPA ONLY
	}
	
	public ObjetivoXObjetivo(Objetivo objetivo, Objetivo objetivoAfectante, Float peso) {
		this.objetivo = objetivo;
		this.objetivoAfectante = objetivoAfectante;
		this.peso = peso;
		this.id = new ObjetivoXObjetivoId(objetivo.getId(), objetivoAfectante.getId());
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
	
        if (o == null || getClass() != o.getClass()) return false;
 
        ObjetivoXObjetivo that = (ObjetivoXObjetivo) o;
        return Objects.equals(objetivo, that.objetivo) &&
               Objects.equals(objetivoAfectante, that.objetivoAfectante);
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(objetivo,objetivoAfectante);
    }
}
