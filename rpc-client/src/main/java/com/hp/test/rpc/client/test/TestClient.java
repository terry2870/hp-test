/**
 * 
 */
package com.hp.test.rpc.client.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hp.test.rpc.model.request.UserRequestBO;
import com.hp.test.rpc.model.response.UserResponseBO;
import com.hp.test.rpc.model.service.IUserService;

/**
 * @author huangping 2018年1月8日
 */
public class TestClient {
	
	static final Logger log = LoggerFactory.getLogger(TestClient.class);
	
	private static ExecutorService exe = Executors.newFixedThreadPool(5);
	private static IUserService service = null;

	public static void main(String[] args) {
		try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-rpc-client.xml")) {
		//try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-rpc-client.xml")) {
			service = (IUserService) ctx.getBean(IUserService.class);
			UserResponseBO response = service.getUser(new UserRequestBO(10, ""));
			log.info("asdasdasd= {}", response);
			for (int i = 0; i < 10; i++) {
				exe.execute(new Run(i));
			}
			
		}
	}
	
	public static class Run implements Runnable {

		private int i;
		
		public Run(int i) {
			this.i = i;
		}
		
		@Override
		public void run() {
			UserResponseBO response = service.getUser(new UserRequestBO(i, ""));
			log.info("getUser with response={}", response);
		}
		
	}
}
