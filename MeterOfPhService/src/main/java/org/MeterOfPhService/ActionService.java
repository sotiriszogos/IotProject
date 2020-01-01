package org.MeterOfPhService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.MeterOfPhPersistence.Action;

@Stateless
public class ActionService extends AbstractService<Action> {

	@PersistenceContext(unitName = "phmeter")
	private EntityManager entityManager;

	public Action find(long id) {
		return super.find(Action.class, id);
	}

	public List<Action> findAll() {
		return super.findAll(Action.class);
	}

}
