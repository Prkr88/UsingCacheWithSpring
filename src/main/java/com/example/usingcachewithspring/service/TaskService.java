package com.example.usingcachewithspring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.usingcachewithspring.aspect.TrackTime;
import com.example.usingcachewithspring.entity.HardTask;

@Service
public class TaskService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@TrackTime
//	@Cacheable(value = "start_a_task", sync = true)
//	@Cacheable(cacheNames = "cacheStore", key = "{#task.id,#task.name,#task.startTime,#task.deadline}", sync = true)
	@Cacheable(cacheNames = "applicationCache", sync = true)
	public String startTask(HardTask task) throws InterruptedException {
		logger.info(String.format("Starting Task: %s.", task.getName()));
		// simulates some work on the task
		String answer = task.startTask();
		return String.format("task %s = %s", task.getName(), answer);
	}

}
