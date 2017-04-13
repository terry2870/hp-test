/**
 * 
 */
package com.hp.test.rpc.springevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import com.hp.test.rpc.bean.TestEventObject;

/**
 * @author ping.huang
 * 2017年3月16日
 */
public class TradeContextListener implements ApplicationListener<TestEventObject> {

	static Logger log = LoggerFactory.getLogger(TradeContextListener.class);

	@Override
	public void onApplicationEvent(TestEventObject event) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info(event.getSource().toString());
	}

}
