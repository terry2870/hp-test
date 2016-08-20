/**
 * 
 */
package com.hp.test.rpc.bean;

import com.hp.tools.common.beans.BaseBean;

/**
 * @author huangping 2016年8月21日 上午12:59:49
 */
public class RpcResponse extends BaseBean {

	private static final long serialVersionUID = 4186113703495368316L;

	private String requestId;
	private Throwable error;
	private Object result;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public Throwable getError() {
		return error;
	}
	public void setError(Throwable error) {
		this.error = error;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
