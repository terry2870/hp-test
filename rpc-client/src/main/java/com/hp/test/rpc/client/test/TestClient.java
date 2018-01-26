/**
 * 
 */
package com.hp.test.rpc.client.test;

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
	
	static Logger log = LoggerFactory.getLogger(TestClient.class);

	public static void main(String[] args) {
		try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-rpc-client.xml")) {
		//try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-rpc-client.xml")) {
			IUserService service = (IUserService) ctx.getBean(IUserService.class);
			
			for (int i = 0; i < 10; i++) {
				UserResponseBO response = service.getUser(new UserRequestBO(i, ""));
				log.info("getUser with response={}", response);
			}
			
		}
	}
}
