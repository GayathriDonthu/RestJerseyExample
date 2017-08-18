package com.restJersey.repository;

import java.util.ArrayList;
import java.util.List;

import com.resetJersey.model.User;
import com.restJersey.model.Activity;

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
	}

	@Override
	public void update(Activity activity) {
		
		// update the id in database
		System.out.println("update database with the id");
		
	}
	
}
