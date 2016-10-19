/**
 * 
 */
package com.hp.test.rpc.bean;

import com.alibaba.fastjson.JSON;

/**
 * @author ping.huang
 * 2016年10月14日
 */
public class User {

	/**
	 * @param id
	 * @param name
	 */
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
