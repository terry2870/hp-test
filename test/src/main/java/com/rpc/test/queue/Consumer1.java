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
public class Consumer1 extends AbstractHPQueueConsumer {
	
	static Logger log = LoggerFactory.getLogger(Consumer1.class);

	@Override
	public void execute(Object message) {
		log.info("message={}", message);
		try {
			Thread.sleep(10000);
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
