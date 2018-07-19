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
public @Data class IndicadorXObjetivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private IndicadorXObjetivoId id;
	
	
	@ManyToOne(fetch = FetchType.EAGER) //Lo pongo en EAGER para no corregir el problema de Error org.hibernate.LazyInitializationException: could not initialize proxy - no Session .
	@MapsId("indicadorId")
	private Indicador indicador;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("objetivoId")
	private Objetivo objetivo;
		
	private Float peso;
	
	
	public IndicadorXObjetivo() { //JPA ONLY
		
	}
	
	public IndicadorXObjetivo(Objetivo objetivo, Indicador indicador, Float peso) {
		this.objetivo = objetivo;
		this.indicador = indicador;
		this.peso = peso;
		this.id = new IndicadorXObjetivoId(indicador.getId(), objetivo.getId());
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        IndicadorXObjetivo that = (IndicadorXObjetivo) o;
        return Objects.equals(indicador, that.indicador) &&
               Objects.equals(objetivo, that.objetivo);
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(indicador,objetivo);
    }
}
