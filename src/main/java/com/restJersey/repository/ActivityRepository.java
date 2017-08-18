package com.restJersey.repository;

import java.util.List;

import com.restJersey.model.Activity;
import com.restJersey.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	void update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch search);

}