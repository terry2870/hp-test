/**
 * 
 */
package com.rpc.test.start;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rpc.test.service.HelloService;

/**
 * @author ping.huang
 * 2017年3月22日
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/hp-rpc-common.xml"})*/
public class RPCTestClient {

	
	public RPCTestClient() {
		System.out.println("RPCTestClient init ");
	}
	
	
	public static void main(String[] args) {
		System.out.println("start");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-rpc-client.xml");
		HelloService h = ctx.getBean(HelloService.class);
		String s = h.hello("12121");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
	}
	
	@Test
	public void t() {
		
		try {
			System.in.read();
			//System.out.println("t5= " + t5.str5().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("t4= " + t4.str4().toString());
		System.out.println("111111111111111111111111111111111111111111111");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*UserBean u = testService.test2(new UserBean("name1", 1, "139"));
		System.out.println(u);
		System.out.println("fffffffffffffffffffffffff");*/
		//System.out.println("aaaa= " + t1.str());
	}
}
