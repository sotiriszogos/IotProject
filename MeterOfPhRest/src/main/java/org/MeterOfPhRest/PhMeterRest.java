package org.MeterOfPhRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.MeterOfPhPersistence.PhData;
import org.MeterOfPhService.PhMeterService;

import com.sun.research.ws.wadl.Response;

@Path("/phdata")
public class PhMeterRest {

	@Inject
	PhMeterService phMeterService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PhData> getAllPhData() {
		return phMeterService.findAll();
	}
	
	@Path("/add")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public PhData postPh(PhData phData) {
		return phMeterService.save(phData);
	}
}
