/**
 * 
 */
package com.rpc.test.excutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ping.huang
 * 2017年4月6日
 */
public class Test {

	static Logger log = LoggerFactory.getLogger(Test.class);
	
	static ExecutorService exe = Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) {
		/*Future<Object> f = exe.submit(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				Thread.sleep(5000);
				return "123456";
			}
		});*/
		
		List<Callable<Boolean>> list = new ArrayList<>();
		list.add(new Callable<Boolean>() {
			
			@Override
			public Boolean call() throws Exception {
				Thread.sleep(5000);
				log.info("1");
				return true;
			}
		});
		
		list.add(new Callable<Boolean>() {
			
			@Override
			public Boolean call() throws Exception {
				Thread.sleep(6000);
				log.info("2");
				return true;
			}
		});
		
		list.add(new Callable<Boolean>() {
			
			@Override
			public Boolean call() throws Exception {
				Thread.sleep(7000);
				log.info("3");
				return true;
			}
		});
		list.add(new Callable<Boolean>() {
			
			@Override
			public Boolean call() throws Exception {
				Thread.sleep(8000);
				log.info("4");
				return true;
			}
		});
		try {
			long start = System.currentTimeMillis();
			log.info("start:" + start);
			List<Future<Boolean>> r = exe.invokeAll(list);
			for (Future<Boolean> f : r) {
				f.get();
			}
			long end = System.currentTimeMillis();
			log.info("end:" + System.currentTimeMillis());
			log.info((end - start) + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		exe.shutdown();
	}
}
