package tesis.bsc.responseBodyObject;

import java.util.Objects;

import lombok.Data;

public @Data class ObjetivoHistory {
	private Float valor;
	private String fecha;
	
	
//	public ObjetivoHistory(Float valor, LocalDate localDate) {
//		this.valor = valor;
//		this.fecha = localDate;
//	}
	
	public ObjetivoHistory(Float valor, String fecha) {
		this.valor = valor;
		this.fecha = fecha;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ObjetivoHistory)) {
            return false;
        }
        ObjetivoHistory oh = (ObjetivoHistory) o;
        return Objects.equals(fecha, oh.fecha);
    }
	
   @Override
    public int hashCode() {
        return Objects.hash(this.fecha);
    }
}
