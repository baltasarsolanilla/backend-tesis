package tesis.bsc.repository.customRepositories;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.transaction.annotation.Transactional;

import tesis.bsc.model.Objetivo;
import tesis.bsc.responseBodyObject.ObjetivoHistory;

public class ObjetivoRepositoryCustomImpl implements ObjetivoRepositoryCustom {
		
		private static final Integer CERO = 0;
		private static final Integer UNO = 1;
		
		@PersistenceContext
	    private EntityManager em;

		@Override
	    @Transactional
	    public HashSet<ObjetivoHistory> findAllObjetivoRevisionByIdAndDate(Integer id, LocalDate fromDate, LocalDate toDate) {
			
			
			Date fromDateInicio = Date.from(fromDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date fromDateFin = Date.from(toDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			AuditReader reader = AuditReaderFactory.get(em);
			
			Number fromRev;
			Number toRev;
			try {
	    		fromRev  = reader.getRevisionNumberForDate(fromDateInicio);
	    	} catch (Exception e) {
				fromRev = new Integer(CERO);
			
			}
			
			try {
				toRev = reader.getRevisionNumberForDate(fromDateFin);
	    	}catch (Exception e) {
				toRev = new Integer(CERO);
			
			}
			
			
	    	AuditQuery query = reader.createQuery().forRevisionsOfEntity(Objetivo.class, false, true)
					.addProjection(AuditEntity.property("valor"))
					.addProjection(AuditEntity.revisionProperty("timestamp"))
	    			.add(AuditEntity.id().eq(id))
	    			/*
	    			 * La siguiente linea comentada esta porque:
	    			 * Si la fecha fromDate es anterior al mínimo nro de revision, entonces tira un error.
	    			 *  .add(AuditEntity.revisionNumber().between(reader.getRevisionNumberForDate(fromDate), reader.getRevisionNumberForDate(toDate)));
	    			 *  .add(AuditEntity.revisionProperty("timestamp").between(date.getTime(), date2.getTime()))
	    			 * Entonces se usa la siguiente.
	    			 */
	    			.add(AuditEntity.revisionNumber().between(fromRev, toRev))
	    			
	    			/*
	    			 * La siguiente linea esta comentada porque:
	    			 * Es otra solucionq que resuelve lo mismo pero menos clara, ya que el nro de revision siempre es creciente en el tiempo.
	    			 * 	.addOrder(AuditEntity.revisionProperty("revisionNumber").asc());
	    			 * Entonces se usa la siguiente.
	    			 */
	    			.addOrder(AuditEntity.revisionProperty("timestamp").desc())
	    			;
	    
	    	
	    	
	    	
	    	List<Object[]> results = query.getResultList();
	    	/*
	    	 * Esta lista de objetos es de la forma: [0]
	    	 * 											[0] - value = 50 (valor del objetivo)
	    	 * 											[1] - value = 123123123123 (timestamp)
	    	 * 										 [1]
	    	 * 											...
	    	 * Asi que recorro esa lista de objetos y lo convierto a algo más manejable: objetivoHistory
	    	 * 
	    	 * Utilizo HashSet con @Override de equals cuando los timestamp son del mismo dia. Ej. 20-Agosto-2018 == 20-Agosto-2018.
	    	 * De esta forma guardo en objetivosHistoricos el último valor de cada día (el valor más cercano a las 23:59:59).
	    	 */
	    	HashSet<ObjetivoHistory> objetivosHistoricos = new HashSet<>();
	    	results.forEach((obj) -> {
	    		Float valor = (Float) obj[CERO];
	    		String fecha = formatDate((long)obj[UNO]);
	    		objetivosHistoricos.add(new ObjetivoHistory(valor, fecha));
	    	});
	    	
	    	return objetivosHistoricos;    	

	    	/* PARA MEJORAR
	    	 * 
	    	 * ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
			long epochFromDate = fromDate.atStartOfDay(zoneId).toEpochSecond();
			long epochToDate = toDate.atStartOfDay(zoneId).toEpochSecond();
			*/
	    	
		    }
		
			private String formatDate(long timestamp) {
			    Calendar c = Calendar.getInstance();
			    c.setTimeInMillis(timestamp);
			    Date d = c.getTime();
			    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			    return sdf.format(d).toString();
			}
}
