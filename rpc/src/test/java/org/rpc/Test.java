/**
 * 
 */
package org.rpc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;

import com.hp.tools.common.utils.MapUtil;
import com.hp.tools.common.utils.MapUtil.FunctionExPlus;

/**
 * @author ping.huang
 * 2016年9月29日
 */
public class Test {

	public static void main(String[] args) {
		try {
			List<String> allIds = IOUtils.readLines(new FileInputStream("C:/Users/ping.huang/Desktop/quan/coupon_use_info.csv"), "GBK");
			List<String> sendList = IOUtils.readLines(new FileInputStream("C:/Users/ping.huang/Desktop/quan/total.csv"), "UTF-8");
			List<String> userList = IOUtils.readLines(new FileInputStream("C:/Users/ping.huang/Desktop/quan/use.csv"), "UTF-8");
			
			Map<Integer, Bean> addBeanMap = MapUtil.list2map(allIds, new FunctionExPlus<String, Integer, Bean>() {

				@Override
				public Integer applyKey(String input) {
					String[] arr = input.split(",");
					return Integer.parseInt(arr[0]);
				}

				@Override
				public Bean applyValue(String input) {
					Bean bean = new Bean();
					String[] arr = input.split(",");
					bean.setId(Integer.parseInt(arr[0]));
					bean.setName(arr[1]);
					return bean;
				}
			});
			System.out.println(123);
			for (String str : sendList) {
				String[] arr = str.split(",");
				if ("".equals(arr[0])) {
					continue;
				}
				Bean bean = addBeanMap.get(Integer.parseInt(arr[0]));
				if (bean != null) {
					bean.setSendNum(bean.getSendNum() + Integer.parseInt(arr[1]));
				}
			}
			
			for (String str : userList) {
				String[] arr = str.split(",");
				if ("".equals(arr[0])) {
					continue;
				}
				Bean bean = addBeanMap.get(Integer.parseInt(arr[0]));
				if (bean != null) {
					bean.setUserNum(bean.getUserNum() + Integer.parseInt(arr[1]));
				}
			}
			
			List<String> list = new ArrayList<>();
			for (Entry<Integer, Bean> entry : addBeanMap.entrySet()) {
				Bean bean = entry.getValue();
				list.add(bean.getId() + "," + bean.getName() + "," + bean.getSendNum() + "," + bean.getUserNum());
			}
			IOUtils.writeLines(list, "\r\n", new FileOutputStream("C:/Users/ping.huang/Desktop/quan/result.csv"), "GBK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
