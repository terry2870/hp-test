/**
 * 
 */
package org.rpc;

import java.lang.reflect.Method;
import java.util.Date;

import javax.xml.ws.spi.Invoker;

import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;

/**
 * @author ping.huang 2016年11月4日
 */
public class TestInvoker {

	private static long l = 333333L;
	private static int times = 10000000;

	public static void main(String[] args) throws Exception {
		// 要分别独立跑，一齐跑相互有影响的。
		test();
		testJDK();
		testFastMethod();
		// testInvoker();
	}

	public static void test() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			Date date = new Date(l);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("直接调用耗时：" + (t1 - t0) + "ms");
	}

	/*public static void testInvoker() throws Exception {
		long t0 = System.currentTimeMillis();
		Date date = new Date();
		Method getMethod = Date.class.getMethod("getTime");
		getMethod.setAccessible(true);
		Method setMethod = Date.class.getMethod("setTime", Long.TYPE);
		setMethod.setAccessible(true);
		Invoker get = Invokers.newInvoker(getMethod);
		Invoker set = Invokers.newInvoker(setMethod);
		for (int i = 0; i < times; i++) {
			get.invoke(date, new Object[] {});
			set.invoke(date, new Object[] { 333333L });
		}
		long t1 = System.currentTimeMillis();
		System.out.println("Invoker调用耗时：" + (t1 - t0) + "ms");
	}*/

	public static void testJDK() throws Exception {
		
		Date date = new Date();
		Method getMethod = Date.class.getMethod("getTime");
		getMethod.setAccessible(true);
		Method setMethod = Date.class.getMethod("setTime", Long.TYPE);
		setMethod.setAccessible(true);
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			getMethod.invoke(date, new Object[] {});
			setMethod.invoke(date, new Object[] { 333333L });
		}
		long t1 = System.currentTimeMillis();
		System.out.println("JDK反射调用耗时：" + (t1 - t0) + "ms");
	}

	public static void testFastMethod() throws Exception {
		
		Date date = new Date();
		FastClass fastClass = FastClass.create(Date.class);
		Method getMethod = Date.class.getMethod("getTime");
		getMethod.setAccessible(true);
		Method setMethod = Date.class.getMethod("setTime", Long.TYPE);
		setMethod.setAccessible(true);
		FastMethod fastGetMethod = fastClass.getMethod(getMethod);
		FastMethod fastSetMethod = fastClass.getMethod(setMethod);
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			fastGetMethod.invoke(date, new Object[] {});
			fastSetMethod.invoke(date, new Object[] { 333333L });
		}
		long t1 = System.currentTimeMillis();
		System.out.println("CGLIB反射调用耗时：" + (t1 - t0) + "ms");
	}
}
