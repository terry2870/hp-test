/**
 * 
 */
package com.hp.test.rpc.start;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huangping
 * 2016年8月21日 上午12:29:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/spring-rpc-server.xml"})
public class RpcBootstrap {

	
	@Test
	public void start() {
		System.out.println("start.....");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
