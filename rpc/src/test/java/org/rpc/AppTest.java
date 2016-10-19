package org.rpc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {
		String str = "http://img11.static.yhbimg.com/yhb-img01/2016/10/19/16/01555c78f6090a8fda89efaf7de2a9c136.mp4,,12121";
		String[] arr = str.split(",");
		System.out.println(arr.length);
	}
	
	
	@Test
	public void test() {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File("D:/3.mp4");
		try {
			urlfile = new URL("http://img11.static.yhbimg.com/yhb-img01/2016/10/17/14/014e80a046df0945dbd31326c8eeac3df9.mp4");
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
