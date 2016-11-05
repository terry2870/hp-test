/**
 * 
 */
package com.hp.test.rpc.service;

import com.hp.test.rpc.bean.User;

/**
 * @author huangping
 * 2016年8月21日 上午12:11:04
 */
public interface HelloService {

	
	String hello(User user);
	
	String hello(String str);
}
