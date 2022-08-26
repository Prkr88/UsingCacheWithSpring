package com.example.usingcachewithspring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.cache.annotation.EnableCaching;

import com.example.usingcachewithspring.entity.HardTask;
import com.example.usingcachewithspring.service.TaskService;


@SpringBootTest
@EnableCaching
class UsingCacheWithSpringApplicationTests {

	@Autowired TaskService taskService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Test
	void contextLoads() {
	}

	@Test
	void testSameTasks() throws InterruptedException {
		HardTask task = new HardTask(1,"A", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), "1");
		logger.info(taskService.startTask(task));
		logger.info(taskService.startTask(task));

	}

	@Test
	void testDifferentTasks() throws InterruptedException {
		HardTask task = new HardTask(1,"A", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), "1");
		HardTask task2 = new HardTask(2,"B", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS),"2");
		logger.info(taskService.startTask(task));
		logger.info(taskService.startTask(task2));
		logger.info(taskService.startTask(task));
		logger.info(taskService.startTask(task2));
	}
}
