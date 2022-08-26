package com.example.usingcachewithspring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class HardTask implements Serializable {

	private int id;
	private String name;
	private String answer;
	private LocalDateTime startTime;
	private LocalDateTime deadline;

	public HardTask(int id, String name, LocalDateTime startTime, LocalDateTime deadline, String answer) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.deadline = deadline;
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public String getAnswer() {
		return answer;
	}

	public String startTask() throws InterruptedException {
		Thread.sleep(1000);
		return this.answer;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HardTask task = (HardTask) o;
		return id == task.id && name.equals(task.name) && startTime.equals(task.startTime) && deadline.equals(task.deadline);
	}

	@Override public int hashCode() {
		return Objects.hash(id, name, startTime, deadline);
	}
}
