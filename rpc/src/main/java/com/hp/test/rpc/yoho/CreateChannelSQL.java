/**
 * 
 */
package com.hp.test.rpc.yoho;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author ping.huang
 * 2017年2月22日
 */
public class CreateChannelSQL {

	
	public static void main(String[] args) {
		try {
			List<String> list = FileUtils.readLines(new File("C:/Users/ping.huang/Desktop/temp/竞品链接170222.csv"), "GBK");
			for (String str : list) {
				if (StringUtils.isEmpty(str)) {
					continue;
				}
				String[] arr = str.split(",", 4);
				if (!arr[0].matches("[0-9]+")) {
					//非数字，跳出
					continue;
				}
				System.out.println("insert into yh_shops.product_url (product_id, product_skn, tmall_url, taobao_url, jd_url, edit_time) select id, "+ arr[0] +", '"+ arr[1] +"', '"+ arr[2] +"', '"+ arr[3] +"', UNIX_TIMESTAMP() from yh_shops.product where erp_product_id="+ arr[0] +" ON DUPLICATE KEY UPDATE tmall_url='"+ arr[1] +"', taobao_url='"+ arr[2] +"', jd_url='"+ arr[3] +"', edit_time=UNIX_TIMESTAMP();");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
