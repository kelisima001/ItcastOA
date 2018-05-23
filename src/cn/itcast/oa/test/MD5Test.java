package cn.itcast.oa.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;


public class MD5Test {

	@Test
	public void TestMD5(){
		String passwdMD5 = DigestUtils.md5Hex("1234");
		System.out.println(passwdMD5);
	}
}
