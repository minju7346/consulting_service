package com.backend.study.user.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	@Scheduled(fixedDelay = 1000)
	public void schedulerTest() {
		System.out.println("scheduler!!!!!!");
	}
}
