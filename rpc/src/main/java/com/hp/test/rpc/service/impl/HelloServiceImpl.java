/**
 * 
 */
package com.hp.test.rpc.service.impl;

import com.hp.test.rpc.annotation.RpcService;
import com.hp.test.rpc.bean.User;
import com.hp.test.rpc.service.HelloService;

/**
 * @author huangping
 * 2016年8月21日 上午12:11:49
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {


	@Override
	public String hello(User user) {
		return "Hello! " + user.toString();
	}

	@Override
	public String hello(String str) {
		return "Hello------! " + str;
	}

}
