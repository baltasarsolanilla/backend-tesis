package tesis.bsc.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
public @Data class IndicadorXObjetivoId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Clave primaria compartida entre Indicadores y Objetivos.
	 */
	@Column(name = "indicador_id")
	private Integer indicadorId;
	
	@Column(name = "objetivo_id")
	private Integer objetivoId;
	
	public IndicadorXObjetivoId(){ //JPA ONLY
		
	}
	
	public IndicadorXObjetivoId(Integer indicadorId, Integer objetivoId) {
		this.indicadorId = indicadorId;
		this.objetivoId = objetivoId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        IndicadorXObjetivoId that = (IndicadorXObjetivoId) o;
        return Objects.equals(indicadorId, that.indicadorId) && 
               Objects.equals(objetivoId, that.objetivoId);
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(indicadorId, objetivoId);
    }

}

/*
 * src: https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
*/