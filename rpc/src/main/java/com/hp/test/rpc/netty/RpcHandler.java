/**
 * 
 */
package com.hp.test.rpc.netty;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.core.common.utils.ObjectUtil;
import com.hp.test.rpc.bean.RpcRequest;
import com.hp.test.rpc.bean.RpcResponse;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author huangping 2016年8月21日 上午1:17:09
 */
public class RpcHandler extends SimpleChannelInboundHandler<RpcRequest> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RpcHandler.class);

	private final Map<String, Object> handlerMap;

	public RpcHandler(Map<String, Object> handlerMap) {
		this.handlerMap = handlerMap;
	}

	@Override
	public void channelRead0(final ChannelHandlerContext ctx, RpcRequest request) throws Exception {
		LOGGER.info("收到请求：{}", request);
		RpcResponse response = new RpcResponse();
		response.setRequestId(request.getRequestId());
		try {
			Object result = handle(request);
			response.setResult(result);
		} catch (Throwable t) {
			response.setError(t);
		}
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private Object handle(RpcRequest request) throws Throwable {
		String className = request.getClassName();
		Object serviceBean = handlerMap.get(className);

		Class<?> serviceClass = serviceBean.getClass();
		String methodName = request.getMethodName();
		Class<?>[] parameterTypes = request.getParameterTypes();
		Object[] parameters = request.getParameters();

		/*
		 * Method method = serviceClass.getMethod(methodName, parameterTypes);
		 * method.setAccessible(true); return method.invoke(serviceBean,
		 * parameters);
		 */

		/*FastClass serviceFastClass = FastClass.create(serviceClass);
		FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);*/
		return ObjectUtil.executeJavaMethod(serviceBean, methodName, parameterTypes, parameters);
		//return serviceFastMethod.invoke(serviceBean, parameters);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		LOGGER.error("server caught exception", cause);
		ctx.close();
	}
}
