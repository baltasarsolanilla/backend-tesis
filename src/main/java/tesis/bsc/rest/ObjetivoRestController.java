package tesis.bsc.rest;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tesis.bsc.model.Indicador;
import tesis.bsc.model.IndicadorXObjetivo;
import tesis.bsc.model.Objetivo;
import tesis.bsc.model.ObjetivoXObjetivo;
import tesis.bsc.requestBodyObject.IndicadorPeso;
import tesis.bsc.responseBodyObject.ObjetivoHistory;
import tesis.bsc.service.ObjetivoService;

@RestController
@RequestMapping("objetivos")
public class ObjetivoRestController {
	
	@Autowired
	private ObjetivoService objetivoService;
	
	/*
	 * PATH: /objetivos
	 */
	
	//Get all Objetivos -- TEST PURPOSE ONLY
	@GetMapping
	public Collection<Objetivo> findAllObjetivos(){
		return objetivoService.findAllObjetivos();
	}
	
	//Create Objetivo -- TEST PURPOSE ONLY
	@PostMapping
	public Objetivo addObjetivo(@RequestBody Objetivo objetivo) {
		return objetivoService.addObjetivo(objetivo);
	}

	/*
	 * PATH: /objetivos/{idObjetivo}
	 */
	
	//Get Objetivo by ID
	@GetMapping(path="/{idObjetivo}")
	public Objetivo getObjetivo(@PathVariable("idObjetivo") int id) {
		return objetivoService.getObjetivo(id);
	}
	
	//Update Objetivo by ID
	@PutMapping(path="/{idObjetivo}")
	public Objetivo updateObjetivo(@PathVariable("idObjetivo") int id, @RequestBody Objetivo objetivo) {
		return objetivoService.updateObjetivo(id, objetivo);	
	}
	
	//Delete Objetivo by ID
	@DeleteMapping(path="{idObjetivo}")
	public void deleteObjetivo(@PathVariable("idObjetivo") int id) {
		objetivoService.deleteObjetivo(id);
	}
	
	/*
	 * PATH: /objetivos/{idObjetivo}/indicadoresAfectantes
	 */
	
	//Get all indicadoresAfectantes
	@GetMapping("{idObjetivo}/indicadoresAfectantes")
	public Collection<IndicadorXObjetivo> getIndicadoresAfectantes(@PathVariable("idObjetivo") int id){
		return objetivoService.getIndicadoresAfectantes(id);
	}

	
	//Add IndicadorAfectante to indicadoresAfectantes by ID
	@PostMapping(path = "/{idObjetivo}/indicadoresAfectantes")
	public Objetivo addIndicadorAfectante(@PathVariable("idObjetivo") int id, @RequestBody IndicadorPeso indicadorPeso) {
		return objetivoService.addIndicadorAfectante(id, indicadorPeso.getIdIndicador(), indicadorPeso.getPeso());
	}
		
	//Delete IndicadorAfectante from indicadoresAfectantes by ID
	//Utiliza PUT ya que lo que realmente hace es modificar la lista de indicadoresAfectante y NO eliminar el recurso asociado a la URI
	@PutMapping(path = "/{idObjetivo}/indicadoresAfectantes")
	public Objetivo deleteIndicadorAfectante(@PathVariable("idObjetivo") int id, @RequestBody Indicador indicador) {
		return objetivoService.deleteIndicadorAfectante(id, indicador);
	}
	
	/*
	 * PATH: /objetivos/{idObjetivo}/objetivosAfectantes
	 */
	
	//Get all objetivosAfectantes
	@GetMapping("{idObjetivo}/objetivosAfectantes")
	public Collection<ObjetivoXObjetivo> getObjetivosAfectantes(@PathVariable("idObjetivo") int id){
		return objetivoService.getObjetivosAfectantes(id);
	}
	
	//Add ObjetivoAfectante to objetivosAfectantes by ID
	@PostMapping("{idObjetivo}/objetivosAfectantes")
	public Objetivo addObjetivoAfectante(@PathVariable("idObjetivo") int id, @RequestBody Objetivo objetivoAfectante) {
		return objetivoService.addObjetivoAfectante(id, objetivoAfectante.getId());
	}
	
	//Delete ObjetivoAfectante to objetivosAfectantes by ID
	//Utiliza PUT ya que lo que realmente hace es modificar la lista de objetivosAfectante y NO eliminar el recurso asociado a la URI
	@PutMapping("{idObjetivo}/objetivosAfectantes")
	public Objetivo deleteObjetivoAfectante(@PathVariable("idObjetivo") int id, @RequestBody Objetivo objetivoAfectante) {
		return objetivoService.deleteObjetivoAfectante(id, objetivoAfectante);
	}
	
	/*
	 * PATH: /objetivos/{idObjetivo}/historico
	 * ej: objetivos/1/valoresHistoricos?fromDate=06022013&toDate=08022013
	 *                                   =06-02-2013 to 08-02-2013
	 */
	@GetMapping("{idObjetivo}/valoresHistoricos")
	public Collection<ObjetivoHistory> getHistorico(@PathVariable("idObjetivo") int id, 
											 @RequestParam(value="fromDate") @DateTimeFormat(pattern="ddMMyyyy") LocalDate fromDate,
											 @RequestParam(value="toDate") @DateTimeFormat(pattern="ddMMyyyy") LocalDate toDate){
		System.out.println("From date " + fromDate.toString() + " to date " + toDate.toString());
		return objetivoService.getValoresHistoricosObjetivo(id, fromDate, toDate);
	}
}
