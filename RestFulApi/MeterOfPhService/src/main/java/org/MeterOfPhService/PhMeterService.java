package org.MeterOfPhService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.MeterOfPhPersistence.PhData;

@Stateless
public class PhMeterService extends AbstractService<PhData> {

	@PersistenceContext(unitName = "phmeter")
	private EntityManager entityManager;

	public PhData find(long id) {
		return super.find(PhData.class, id);
	}

	public List<PhData> findAll() {
		return super.findAll(PhData.class);
	}
	
	public PhData save(PhData phData) {
		return super.save(phData);
	}
}
