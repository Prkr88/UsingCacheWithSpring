package com.example.usingcachewithspring.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("@annotation(com.example.usingcachewithspring.aspect.TrackTime)")
	public void trackTimeAnnotation(){}
}
