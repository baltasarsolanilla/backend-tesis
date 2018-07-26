package tesis.bsc.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
public @Data class ObjetivoXObjetivoId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "objetivo_id")
	private Integer objetivoId;
	
	@Column(name = "objetivoAfectante_id")
	private Integer objetivoAfectanteId;
	
	public ObjetivoXObjetivoId() { //JPA ONLY
	}
	
	public ObjetivoXObjetivoId(Integer objetivoId, Integer objetivoAfectanteId) {
		this.objetivoId = objetivoId;
		this.objetivoAfectanteId = objetivoAfectanteId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		ObjetivoXObjetivoId that = (ObjetivoXObjetivoId)o;
		return Objects.equals(objetivoId, that.objetivoId) && 
			   Objects.equals(objetivoAfectanteId, that.objetivoAfectanteId);
	}
	

    @Override
    public int hashCode() {
        return Objects.hash(objetivoId, objetivoAfectanteId);
    }

}
