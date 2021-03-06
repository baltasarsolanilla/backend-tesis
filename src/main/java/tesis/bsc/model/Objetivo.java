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

import org.hibernate.envers.Audited;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public @Data class Objetivo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final float CERO = 0.0f;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	
	@Audited(withModifiedFlag=true)
	private Float valor;
	
	private Enum<Tendencia> tendencia;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndicadorXObjetivo> indicadoresAfectantes;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoXObjetivo> objetivosAfectantes;
		
	
	public Objetivo() { //JPA only
    }
	
	public Objetivo(String nombre, String descripcion) {
		this.indicadoresAfectantes = new ArrayList<>();
		this.objetivosAfectantes = new ArrayList<>();
		this.nombre = nombre;
		this.descripcion = descripcion;
//		this.valor = CERO;
//		this.tendencia = Tendencia.MEDIA;
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
		this.indicadoresAfectantes.add(ixo);
		return true;
	}
	
	public boolean removeIndicador(Indicador indicador) {
		Iterator<IndicadorXObjetivo> iterator = this.indicadoresAfectantes.iterator();
		while (iterator.hasNext()) {
			IndicadorXObjetivo ixo = iterator.next();
			if (ixo.getObjetivo().equals(this) && ixo.getIndicador().equals(indicador)) {
				iterator.remove();
				ixo.setObjetivo(null);
				ixo.setIndicador(null);
				this.actualizar();
				return true;
			}
		}
		return false;
	}
	
	public boolean addObjetivo(Objetivo objetivoAfectante) {
		ObjetivoXObjetivo oxo = new ObjetivoXObjetivo(this, objetivoAfectante);
		this.actualizar();
		return this.objetivosAfectantes.add(oxo);
	}
	
	public boolean removeObjetivo(Objetivo objetivoAfectante) {
		Iterator<ObjetivoXObjetivo> iterator = this.objetivosAfectantes.iterator();
		while (iterator.hasNext()) {
			ObjetivoXObjetivo oxo = iterator.next();
			if (oxo.getObjetivo().equals(this) && oxo.getObjetivoAfectante().equals(objetivoAfectante)) {
				iterator.remove();
				oxo.setObjetivo(null);
				oxo.setObjetivoAfectante(null);
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
    
    /*
     * Observer
     * Este método actualiza el "valor",
     * de acuerdo a los indicadores y objetivos que lo afecten.
     */
    
    public void actualizar() {
    	if (indicadoresAfectantes.size() > 0) {
    		float viejo_valor = CERO;
    		if (this.valor != null) {
    			viejo_valor= this.valor;
    		}
        	float nuevo_valor = CERO;
        	float peso_acumulado = CERO; //Es float por razones de conversiones, pero es un valor entero.
    		for (IndicadorXObjetivo ixo : indicadoresAfectantes) {
    			peso_acumulado += ixo.getPeso();
    		}
    		for (IndicadorXObjetivo ixo : indicadoresAfectantes) {
    			nuevo_valor += (ixo.getPeso() / peso_acumulado) * ixo.getIndicador().getValor();
    		}
    		this.setValor(nuevo_valor);
    		
    		this.tendencia = actualizarTendencia(viejo_valor, nuevo_valor);
    	}
    }
    
        
    private Enum<Tendencia> actualizarTendencia(float viejo_valor, float nuevo_valor) {
    	if (nuevo_valor - viejo_valor > 1) return Tendencia.ALTA;
    	if (nuevo_valor - viejo_valor < -1) return Tendencia.BAJA;
    	return Tendencia.MEDIA;
	}

	public enum Tendencia {
    	ALTA,
    	MEDIA,
    	BAJA
    }
}

