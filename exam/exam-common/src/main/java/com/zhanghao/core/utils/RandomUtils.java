package com.zhanghao.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;
import java.util.Random;

public class RandomUtils {
	private static final String FILE_NAME = "random.properties";
	private static Random random = new Random();
	private static Properties properties = new Properties();

	static {
		InputStream in = RandomUtils.class.getClassLoader().getResourceAsStream(FILE_NAME);
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取随机位数的字符串
	 *
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 随机产生手机号
	 *
	 */
	public static String randomPhone() {
		int pre[] = { 131, 132, 133, 134, 135, 136, 137, 138, 138, 151, 152, 153, 154, 155, 156, 157, 158, 159, 188 };
		StringBuffer phone = new StringBuffer(11);
		int nextInt = random.nextInt(pre.length);
		phone.append(pre[nextInt]);
		for (int i = 0; i < 8; i++) {
			phone.append(random.nextInt(9));
		}
		return phone.toString();
	}

	/**
	 * 随机产生邮箱
	 *
	 */
	public static String randomEmail() {
		String suffix[] = { "@gmail.com", "@yahoo.com", "@msn.com", "@hotmail.com", "@aol.com", "@ask.com", "@live.com",
				"@qq.com", "@0355.net", "@163.com", "@163.net", "@263.net", "@3721.net", "@yeah.net", "@googlemail.com",
				"@mail.com}" };
		StringBuffer email = new StringBuffer(11);
		int nextInt = random.nextInt(suffix.length);
		return email.append(getRandomString(random.nextInt(13) + 6)).append(suffix[nextInt]).toString();
	}
	/**
	 * 随机产生中文姓名
	 * @param args
	 */
	public static String randomChineName() {
		String firstName = properties.getProperty("firstName");
		return "";
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 30; i++) {
			System.out.println(RandomUtils.randomEmail());
		}
	}
}
