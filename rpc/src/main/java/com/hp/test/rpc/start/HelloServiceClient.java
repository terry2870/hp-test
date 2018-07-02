/**
 * 
 */
package com.hp.test.rpc.start;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hp.core.common.utils.DateUtil;
import com.hp.test.rpc.bean.User;
import com.hp.test.rpc.netty.RpcProxy;
import com.hp.test.rpc.service.HelloService;

/**
 * @author huangping 2016年8月21日 上午1:27:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/spring-rpc-client.xml" })
public class HelloServiceClient {

	Logger log = LoggerFactory.getLogger(HelloServiceClient.class);
	
	@Resource
	private RpcProxy rpcProxy;
	
	HelloService helloService = null;

	@Test
	public void helloTest() {
		helloService = rpcProxy.create(HelloService.class);
		
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 1; i++) {
			exe.execute(new Run(i));
		}
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public class Run implements Runnable {

		private int i;
		
		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		/**
		 * @param i
		 */
		public Run(int i) {
			super();
			this.i = i;
		}

		@Override
		public void run() {
			
			log.info("send= " + i);
			String str = "";
			while (str.length() < 20) {
				str += DateUtil.getCurrentTimeSeconds();
			}
			User user = new User(i, str + "_" + i);
			String result = helloService.hello(user.toString());
			
			log.info("result= " + result);
		}
		
	}
}
