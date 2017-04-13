/**
 * 
 */
package com.rpc.test.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.tools.common.queue.AbstractHPQueueConsumer;

/**
 * @author ping.huang
 * 2017年3月31日
 */
public class Consumer2 extends AbstractHPQueueConsumer {
	
	static Logger log = LoggerFactory.getLogger(Consumer2.class);

	@Override
	public void execute(Object message) {
		log.info("message_top2={}", message);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.hp.tools.common.queue.AbstractHPQueueConsumer#getTopic()
	 */
	@Override
	public String getTopic() {
		// TODO Auto-generated method stub
		return null;
	}

}
