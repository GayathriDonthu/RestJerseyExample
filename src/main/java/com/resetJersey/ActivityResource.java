package com.resetJersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.resetJersey.model.User;
import com.restJersey.model.Activity;
import com.restJersey.repository.ActivityRepository;
import com.restJersey.repository.ActivityRepositoryStub;

@Path("/activities") // http://localhost:8080/exercise-services/webapi/activities
public class ActivityResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Activity activity){
		
		System.out.println(activity.getId());
		
		activityRepository.update(activity);
		
		return Response.ok().entity(activity).build();
		
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Activity createActivity(Activity activity){
		System.out.println("Welcome to Exercise Service");
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		
		activityRepository.create(activity);
		
		return activity;
		
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParams(MultivaluedMap<String, String> formParams){
		
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		activityRepository.create(activity);
		
		return activity;
		
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Activity> findAllActivities(){
		
		System.out.println("Getting all activities");
		
		return activityRepository.findAllActivities();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{activityId}") //http://localhost:8080/exercise-services/webapi/activities/22
	public Response getActivity(@PathParam ("activityId") String activityId ){
		
		if(activityId ==  null || activityId.length() < 2){
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity = activityRepository.findActivity(activityId);
		
		if(activity == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(activity).build();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{activityId}/user") //http://localhost:8080/exercise-services/webapi/activities/22/user
	public User findActivityUser(@PathParam ("activityId") String activityId){
		
		return activityRepository.findActivity(activityId).getUser();
		
	}
	
	
}
