package com.restJersey.repository;

import java.util.List;

import com.restJersey.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	void update(Activity activity);

}