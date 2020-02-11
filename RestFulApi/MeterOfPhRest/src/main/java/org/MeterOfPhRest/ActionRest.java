package org.MeterOfPhRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.MeterOfPhPersistence.Action;
import org.MeterOfPhService.ActionService;

@Path("/action")
public class ActionRest {

	@Inject
	ActionService actionService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Action> getAllPhData() {
		return actionService.findAll();
	}

}
