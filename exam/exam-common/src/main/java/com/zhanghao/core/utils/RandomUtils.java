package com.zhanghao.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * 随机数据生成工具类，用来模拟生成数据
 * @作者： zhanghao
 *
 * @时间：@2017年11月3日 上午10:37:09
 */
public class RandomUtils {
	private static final String FILE_NAME = "random.properties";
	private static Random random = new Random();
	private static Properties properties = new Properties();

	static {
		InputStream in = RandomUtils.class.getClassLoader().getResourceAsStream(FILE_NAME);
		try {
			properties.load(new InputStreamReader(in, "UTF-8"));
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
	 * 获取随机位数的数字
	 *
	 */
	public static String getRandomNumString(int length) {
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(9);
			sb.append(number);
		}
		return sb.toString();
	}

	/**
	 * 获取产生一个范围的数据
	 * 
	 */
	public static int getRangeNum(int min, int max) {
		return random.nextInt(max - min) + min;
	}

	/**
	 * 获取产生0一个整数
	 * 
	 */
	public static int getNum(int max) {
		return getRangeNum(0, max);
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
		return email.append(getRandomString(getRangeNum(6, 18))).append(suffix[nextInt]).toString();
	}

	/**
	 * 随机产生中文姓名,拼音，性别
	 * 
	 * @param args
	 */
	public static String randomChineName() {
		// Map<String, String> map=new HashMap<String, String>();
		String firstName = properties.getProperty("firstName");
		char charAt = firstName.charAt(random.nextInt(firstName.length()));
		int sex = random.nextInt(1);
		char name = 'a';
		if (sex == 0) {// 男生
			String boy = properties.getProperty("boy");
			name = boy.charAt(random.nextInt(boy.length()));
		} else {
			String girl = properties.getProperty("girl");
			name = girl.charAt(random.nextInt(girl.length()));
		}
		// map.put("name", new String(new char[]{charAt,name}));
		// map.put("sex", sex+"");
		return new String(new char[] { charAt, name });
	}

	/**
	 * 随机产生街道
	 * 
	 * @return
	 */
	public static String randomRoad() {
		String property = properties.getProperty("road");
		String[] split = property.split(",");
		return split[random.nextInt(split.length)] + getRangeNum(11, 778) + "号";
	}

	/**
	 * 随机产生年月日的日期字符串
	 * @param minYear
	 * @param maxYear
	 * @return
	 */
	public static String randomDate(int minYear, int maxYear) {
		int year = getRangeNum(minYear, maxYear);
		int mouth = getRangeNum(1, 12);
		int day = getRangeNum(1, 30);
		switch (mouth) {
		case 2:
			day = DateUtils.isLeapYear(year) ? day - 2 : day - 1;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = day + 1;
			break;
		}
		DecimalFormat format=new DecimalFormat("00");
		return new StringBuffer().append(year).append("-").append(format.format(mouth)).append("-").append(format.format(day)).toString();
	}
	
	/**
	 * 随机产生年月日 时分秒的日期字符串
	 * @param minYear
	 * @param maxYear
	 * @return
	 */
	public static String randomDateTime(int minYear, int maxYear) {
		int year = getRangeNum(minYear, maxYear);
		int mouth = getRangeNum(1, 12);
		int day = getRangeNum(1, 30);
		switch (mouth) {
		case 2:
			day = DateUtils.isLeapYear(year) ? day - 2 : day - 1;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = day + 1;
			break;
		}
		DecimalFormat format=new DecimalFormat("00");
		return new StringBuffer().append(year).append("-").append(format.format(mouth)).append("-").append(format.format(day)).append(" ")//格式化年月日
				.append(format.format(getRangeNum(0,24))).append(":").append(format.format(getNum(60))).append(":").append(format.format(getNum(60))).toString();//;
	}

	public static void main(String[] args) throws Exception {
		//DecimalFormat format=new DecimalFormat("00");
		//System.out.println(format.format(4));
		for (int i = 0; i <= 30; i++) {
			System.out.println(randomDateTime(1997,2005));
		}
	}
}
