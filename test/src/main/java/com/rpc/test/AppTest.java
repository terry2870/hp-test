package com.rpc.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {
		try {
			String str = FileUtils.readFileToString(new File("D:/1.txt"), "UTF-8");
			System.out.println(str);
			
			JSONObject json = JSON.parseObject(str);
			System.out.println(json);
			System.out.println(json.get("s"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
