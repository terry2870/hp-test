package com.rpc.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.hp.tools.common.utils.MD5Util;
import com.hp.tools.common.utils.MapUtil;
import com.hp.tools.common.utils.MapUtil.Function;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {
		/*try {
			List<String> skns = FileUtils.readLines(new File("E:/log/skns.txt"), "UTF-8");
			List<String> list = new ArrayList<>();
			List<String> urls = FileUtils.readLines(new File("E:/log/product_url.csv"), "UTF-8");
			Map<String, String> map = MapUtil.list2map(urls, new Function<String, String>() {

				@Override
				public String apply(String input) {
					String[] arr = input.split(",");
					return arr[0];
				}
			});
			for (String str : skns) {
				list.add(map.get(str));
			}
			FileUtils.writeLines(new File("C:/Users/ping.huang/Desktop/temp/444.csv"), list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		System.out.println(MD5Util.getMD5("123456"));
	}
}
