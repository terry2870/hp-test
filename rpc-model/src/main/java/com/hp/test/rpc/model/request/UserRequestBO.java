/**
 * 
 */
package com.hp.test.rpc.model.request;

import com.hp.core.common.beans.BaseBean;

/**
 * @author huangping
 * 2018年1月8日
 */
public class UserRequestBO extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7872657409282579063L;

	private Integer id;
	private String userName;

	public UserRequestBO(Integer id, String userName) {
		this.id = id;
		this.userName = userName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
