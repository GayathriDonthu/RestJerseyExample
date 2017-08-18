package com.resetJersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.restJersey.model.Activity;
import com.restJersey.model.ActivitySearch;
import com.restJersey.repository.ActivityRepository;
import com.restJersey.repository.ActivityRepositoryStub;

@Path("search/activities")
public class ActivitySearchResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchFOrActivities(ActivitySearch search){
		
		System.out.println(search.getDescriptions() + "," + search.getDurationFrom() +  ", " + search.getDurationTo());
		
		List<Activity> activities = activityRepository.findByConstraints(search);
		
		System.out.println(activities);
		
		if(activities == null || activities.size() == 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Activity>> (activities) {}).build();
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions,
			@QueryParam(value = "durationFrom") int durationFrom, @QueryParam("durationTo") int durationTo) {

		System.out.println("ActivitySearchResource : descriptions :" + descriptions + ", durationFrom:" + durationFrom + ", durationTo : " + durationTo);

		List<Activity> activities = activityRepository.findByDescription(descriptions, durationFrom, durationTo);

		System.out.println("ActivitySearchResource :: activities : " + activities);

		if (activities == null || activities.size() == 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		System.out.println(Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
		}).build());
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
		}).build();

	}

}
