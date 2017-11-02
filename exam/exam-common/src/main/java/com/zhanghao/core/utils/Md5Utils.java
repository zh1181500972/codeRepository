package com.zhanghao.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密工具类
 * 
 * @author Administrator
 *
 */
public class Md5Utils {
	
	/**
	 * md5 盐值加密
	 * @param str 
	 * @param salt
	 * @return
	 */
	public static String encode(String str,String salt){
		return encodeMd5((str+salt).getBytes());
	}
	
	/**
	 * 校验md5加密是否正确
	 * @param str 原str
	 * @param salt 加密的 盐值
	 * @param md5  加密后的MD5字符串
	 * @return
	 */
	public static boolean validate(String str,String salt,String md5){
		return encode(str,salt).equals(md5);
	}
	
	private static String encodeMd5(byte[] source) {
		try {
			return encodeHex(MessageDigest.getInstance("MD5").digest(source));
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	private static String encodeHex(byte[] bytes) {
		StringBuffer buffer = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10)
				buffer.append("0");
			buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buffer.toString();
	}
}
