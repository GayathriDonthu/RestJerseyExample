package com.restJersey.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.restJersey.model.Activity;
import com.restJersey.model.ActivitySearch;
import com.restJersey.model.ActivitySearchType;

public class ActivityClientTest {

	private ActivityClient client = new ActivityClient();
	
	
	@Test
	public void testSearchObject(){
		
		ActivitySearchClient searchClient = new ActivitySearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("swimming");
		searchValues.add("running");
		
		
		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(60);
		search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
		
		List<Activity> activities = searchClient.searchActivities(search);
		
		System.out.println(activities);
		
		assertNotNull(activities);
		
	}
	
	@Test
	public void testSearch(){
		
		ActivitySearchClient searchclient = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("swimming");
		searchValues.add("running");
		
		String secondParam = "durationFrom";
		int durationFrom = 30;
		
		String thirdParam = "durationTo";
		int durationTo = 60;
		
		List<Activity> activities = searchclient.searchActivities(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
		
		System.out.println("ActivityClientTest :: actvities : "+ activities);
		
		assertNotNull(activities);
		
		
	}
	
	@Test
	public void testDelete(){
		
		client.delete("123");
		
	}
	
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
