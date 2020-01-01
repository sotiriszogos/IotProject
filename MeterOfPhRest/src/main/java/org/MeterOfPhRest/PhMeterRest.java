package org.MeterOfPhRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.MeterOfPhPersistence.PhData;
import org.MeterOfPhService.PhMeterService;

@Path("/phdata")
public class PhMeterRest {

	@Inject
	PhMeterService phMeterService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PhData> getAllPhData() {
		return phMeterService.findAll();
	}
	
}
