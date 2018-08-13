package com.vigoss.wechat.enterprise.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * sha-1加密
 * @author lhyan3
 * 2015年5月22日上午8:31:23
 */
public class SHAUtil {

	/**
	 * 加密
	 * lhyan3
	 * 2015年5月21日下午1:54:37
	 * TODO
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String digestSHA(String temp) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(temp.getBytes());
		String result =  byteArrayToHex(md.digest());
		return result;
	}
	
	/**
	 * 用于将字节数组换成成16进制的字符串
	 * @param byteArray
	 * @return
	 */
	public static String byteArrayToHex(byte[] byteArray) {
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];

		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}

		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String timestamp = new Date().getTime()+"";
		timestamp = timestamp.substring(0, timestamp.length()-3);
		System.out.println(timestamp);
		System.out.println("sM4AOVdWfPE4DxkXGEs8VN-nkNRwnukZDeCVhHF7Ywbu96QcmhQETp0XTN0seghpLYl2c47-Fkt5x6-k0XFelw".equals("sM4AOVdWfPE4DxkXGEs8VN-nkNRwnukZDeCVhHF7Ywbu96QcmhQETp0XTN0seghpLYl2c47-Fkt5x6-k0XFelw"));
		System.out.println(digestSHA("jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VN-nkNRwnukZDeCVhHF7YwaqkBwSilwSejB3Ww5pVk0rn5yMRIom0dBIAm-Iu5wNPw&noncestr=9bad1fa460b440ccaad1650348ffb9f7&timestamp=1433215892711&url=http://ytxxfwtest.grgbanking.com/wxsc/lbstest/photo.jsp?accountId=101"));
	}
	
	
}
