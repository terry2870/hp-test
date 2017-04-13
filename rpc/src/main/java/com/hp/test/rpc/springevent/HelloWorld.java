/**
 * 
 */
package com.hp.test.rpc.springevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.hp.test.rpc.bean.TestEventObject;

/**
 * @author ping.huang 2017年3月16日
 */
public class HelloWorld implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	static Logger log = LoggerFactory.getLogger(HelloWorld.class);
	
	public void say(String word) {
		log.info("say : " + word);
		TestEventObject event = new TestEventObject(word);
		this.applicationEventPublisher.publishEvent(event);
		log.info("111111");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}


}
