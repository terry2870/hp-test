/**
 * 
 */
package com.hp.test.rpc.server;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangping
 * 2018年1月8日
 */
public class TestServer {

	
	public static void main(String[] args) {
		System.out.println("start");
		try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-rpc-server.xml")) {
			System.in.read();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
