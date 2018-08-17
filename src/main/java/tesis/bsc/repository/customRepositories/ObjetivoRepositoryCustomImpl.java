package tesis.bsc.repository.customRepositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.transaction.annotation.Transactional;

import tesis.bsc.model.Objetivo;

public class ObjetivoRepositoryCustomImpl implements ObjetivoRepositoryCustom {

		@PersistenceContext
	    private EntityManager em;

	    @Override
	    @Transactional
	    public Objetivo findObjRevision(Integer id, Integer rev) {
	    	AuditReader reader = AuditReaderFactory.get(em);
	   
	    	//Inicio chanchada
	    	Date fromDate = new Date();
	    	Date toDate = new Date();
	    	
	    	AuditQuery query = reader.createQuery().forRevisionsOfEntity(Objetivo.class, false, true);
	    	query.add(AuditEntity.id().eq(id));
	    	//query.add(AuditEntity.revisionNumber().between(reader.getRevisionNumberForDate(fromDate), reader.getRevisionNumberForDate(toDate)));
	    	 
	    	List<Objetivo> results = query.getResultList();
	    	
	    	
	    	List<Number> results2 = reader.getRevisions(Objetivo.class, id);
	    	
	    	//Fin chanchada
	    	
    	 	Date fechaRevision = reader.getRevisionDate(rev);
	    	System.out.println("Fecha de revision " + rev  + " igual a: " + fechaRevision.toString());
	    	return reader.find(Objetivo.class, id, rev);
	    }
	    
}
