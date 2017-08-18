package com.restJersey.repository;

import java.util.ArrayList;
import java.util.List;

import com.restJersey.model.User;
import com.restJersey.model.Activity;
import com.restJersey.model.ActivitySearch;

public class ActivityRepositoryStub implements ActivityRepository {
	
	/* (non-Javadoc)
	 * @see com.restJersey.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities(){
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity walk = new Activity();
		walk.setDescription("Walk");
		walk.setDuration(60);
		
		activities.add(walk);
		
		Activity run = new Activity();
		run.setDescription("Run");
		run.setDuration(30);
		
		activities.add(run);
		
		return activities;
		
	}

	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("7777")){
			return null;
		}
			
		Activity activity1 = new Activity();
		activity1.setDescription("swim");
		activity1.setDuration(30);
		activity1.setId("22");
		
		User user = new User();
		user.setId(1);
		user.setName("Gayathri");
		
		activity1.setUser(user);

		return activity1;
	}

	@Override
	public void create(Activity activity) {
		
		// insert method to save in database
		System.out.println("ActivityRepositoryStub :: create activity in database");
	}

	@Override
	public void update(Activity activity) {
		
		// update the id in database
		System.out.println("ActivityRepositoryStub :: update database with the id");
		
	}

	@Override
	public void delete(String activityId) {
		
		// delete the activityid
		System.out.println("ActivityRepositoryStub :: delete the id in database");
		
	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		
		// select * from Activity where description IN (?,?,?) and duration > ? and duration < ?
		
		System.out.println("ActivityRepositoryStub :: searching values in the database");
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setId("5678");
		activity1.setDescription("swimming");
		activity1.setDuration(45);
		
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setId("9034");
		activity2.setDescription("running");
		activity2.setDuration(30);
		
		activities.add(activity2);
		
		System.out.println("ActivityRepositoryStub :: actvities : " + activities);
		
		return activities;
	}

	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {
		
		System.out.println("ActivityRepositoryStub :: searching values in the database");
		
		System.out.println(search.getSearchType());
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setId("5678");
		activity1.setDescription("swimming");
		activity1.setDuration(45);
		
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setId("9034");
		activity2.setDescription("running");
		activity2.setDuration(30);
		
		activities.add(activity2);
		
		System.out.println("ActivityRepositoryStub :: actvities : " + activities);
		
		return activities;
	}
	
}
