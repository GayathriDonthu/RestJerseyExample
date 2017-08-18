package com.restJersey.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.restJersey.model.Activity;

public class ActivityClientTest {

	private ActivityClient client = new ActivityClient();
	
	
	@Test
	public void testPut(){
		
		Activity activity = new Activity();
		
		activity.setId("3456");
		activity.setDescription("yoga");
		activity.setDuration(70);
		activity = client.update(activity);
		
		assertNotNull(activity);
		
	}
	
	@Test
	public void testCreate() {
		
		Activity activity = new Activity();
		activity.setDescription("swimming");
		activity.setDuration(30);
		
		System.out.println(activity);
		activity = client.create(activity);
		
		assertNotNull(activity);
		
	}
	

	@Test
	public void testGet() {

		Activity activity = client.get("22");

		System.out.println(activity);

		assertNotNull(activity);

	}

	@Test
	public void testGetList() {

		List<Activity> activities = client.get();

		System.out.println(activities);

		assertNotNull(activities);

	}

	@Test(expected = RuntimeException.class)
	public void testGetBadRequest() {

		Activity activity = client.get("4");

		assertNotNull(activity);

	}

	@Test(expected = RuntimeException.class)
	public void testGetNotFound() {

		Activity activity = client.get("7777");
		assertNotNull(activity);

	}
	
	
	

}
