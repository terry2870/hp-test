/**
 * 
 */
package com.hp.test.rpc.bean;

import org.springframework.context.ApplicationEvent;

/**
 * @author ping.huang
 * 2017年3月16日
 */
public class TestEventObject extends ApplicationEvent {

	/**
	 * @param source
	 */
	public TestEventObject(Object source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1239686695110375541L;

}
