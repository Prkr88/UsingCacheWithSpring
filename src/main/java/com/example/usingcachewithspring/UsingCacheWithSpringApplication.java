package com.example.usingcachewithspring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

import com.example.usingcachewithspring.entity.HardTask;
import com.example.usingcachewithspring.service.TaskService;

@EnableCaching
@SpringBootApplication
public class UsingCacheWithSpringApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final TaskService taskService;
	private final CacheManager cacheManager;

	public UsingCacheWithSpringApplication(TaskService taskService, CacheManager cacheManager) {
		this.taskService = taskService;
		this.cacheManager = cacheManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(UsingCacheWithSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		HardTask task = new HardTask(1, "A", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), "1");
		HardTask task2 = new HardTask(2, "B", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), "2");

		List<HardTask> tasks = List.of(task, task, task2, task2);
		tasks.forEach(t -> {
			new Thread(() -> {
				try {
					logger.info(taskService.startTask(t));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		});
	}

}
