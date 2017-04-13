/**
 * 
 */
package com.rpc.test.queue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hp.tools.common.queue.HPQueueProducer;

/**
 * @author ping.huang
 * 2017年3月31日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/spring-queue*.xml"})
public class TestQueue {

	@Autowired
	HPQueueProducer hpQueueProducer;
	
	@Test
	public void test1() {
		for (int i = 0; i < 10; i++) {
			hpQueueProducer.send("topic1", "message_" + i);
		}
		for (int i = 0; i < 10; i++) {
			hpQueueProducer.send("topic2", "message_top2_" + i);
		}
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
