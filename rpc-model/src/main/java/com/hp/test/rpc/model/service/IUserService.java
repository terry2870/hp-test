/**
 * 
 */
package com.hp.test.rpc.model.service;
/**
 * @author huangping
 * 2018年1月8日
 */

import com.hp.test.rpc.model.request.UserRequestBO;
import com.hp.test.rpc.model.response.UserResponseBO;

public interface IUserService {

	
	public UserResponseBO getUser(UserRequestBO request);
}
