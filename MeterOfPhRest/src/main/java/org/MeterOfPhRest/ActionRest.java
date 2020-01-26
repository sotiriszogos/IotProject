package org.MeterOfPhRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.MeterOfPhPersistence.Action;
import org.MeterOfPhService.ActionService;

import com.sun.research.ws.wadl.Response;

@Path("/action")
public class ActionRest {

	@Inject
	ActionService actionService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Action> getAllActions() {
		return actionService.findAll();
	}
	
	@Path("/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response makeAction(@PathParam("id") int id) {
		actionService.save(id);
		return null;
	}
	
	@Path("/actionNow")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Action getEnabledAction() {
		return actionService.findEnabled();
	}
}
