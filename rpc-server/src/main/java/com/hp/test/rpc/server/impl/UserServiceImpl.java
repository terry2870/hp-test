/**
 * 
 */
package com.hp.test.rpc.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hp.test.rpc.model.request.UserRequestBO;
import com.hp.test.rpc.model.response.UserResponseBO;
import com.hp.test.rpc.model.service.IUserService;

/**
 * @author huangping
 * 2018年1月8日
 */
@Service
public class UserServiceImpl implements IUserService {

	static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserResponseBO getUser(UserRequestBO request) {
		log.info("getUser with request={}", request);
		return new UserResponseBO(request.getId(), "名称_" + request.getId());
	}

}
