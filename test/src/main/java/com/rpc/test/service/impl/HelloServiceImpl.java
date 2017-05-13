/**
 * 
 */
package com.rpc.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rpc.test.bean.User;
import com.rpc.test.service.HelloService;

/**
 * @author ping.huang
 * 2017年4月17日
 */
@Service
public class HelloServiceImpl implements HelloService {

	static Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	/*@Override
	public String hello(User user) {
		log.info("hello user={}", user);
		return user.getName() + "_asfasdf";
	}*/


	@Override
	public String hello(String str) {
		log.info("hello str={}", str);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "收到____" + str;
	}

}
