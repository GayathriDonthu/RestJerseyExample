package com.restJersey.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restJersey.model.Activity;

public class ActivityClient {

	private Client client;
	
	private WebTarget target;

	public ActivityClient() {

		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/exercise-services/webapi/");

	}

	public Activity get(String id) {

		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON)
				.get(Response.class);
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there is an error on server");
		}

		return response.readEntity(Activity.class);

	}
	
	public List<Activity> get(){
		
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
		
		return response;
		
	}

	public Activity create(Activity activity) {
		
		// http://localhost:8080/exercise-services/webapi/activities/activity
		
		System.out.println("Activity creation: " + activity);
		
		Response response = target.path("activities/activity")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		System.out.println("response: "+ response);
		/*if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there is an error on server");
		}*/
		return response.readEntity(Activity.class);
	}

}
