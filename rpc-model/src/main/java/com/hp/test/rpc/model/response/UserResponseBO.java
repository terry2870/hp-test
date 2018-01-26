/**
 * 
 */
package com.hp.test.rpc.model.response;

import com.hp.tools.common.beans.BaseBean;

/**
 * @author huangping
 * 2018年1月8日
 */
public class UserResponseBO extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7162821571733850414L;

	
	private Integer id;
	private String userName;

	public UserResponseBO(Integer id, String userName) {
		super();
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
