package com.example.usingcachewithspring.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void onEvent(
			CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		logger.info("message",
				cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
	}
}