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
	
	public Action save(int id) {
		Action currentAction = entityManager.createNamedQuery("Action.findEnabledActions", Action.class).getResultList().get(0);
		currentAction.setEnable(false);
		entityManager.persist(currentAction);
		Action newAction = find(id);
		newAction.setEnable(true);
		return super.save(newAction);
	}

	public Action findEnabled() {
		Action currentAction = entityManager.createNamedQuery("Action.findEnabledActions", Action.class).getResultList().get(0);
		return currentAction;
	}
}
