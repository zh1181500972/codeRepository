package com.zhanghao.java8.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Predicate;

import org.junit.Test;
import org.zhanghao.java8.feature.Feature1;
import org.zhanghao.java8.feature.FunctionInterface;
import org.zhanghao.java8.feature.impl.FeatureImpl;

public class Feature1Test {
	
	@Test
	public void test() {
		Properties properties = System.getProperties();
		for (Object obj : properties.keySet()) {
			System.out.println(obj+"="+properties.getProperty(obj.toString()));
		}
	}
	
	@Test
	public void testFunctionInterface() {
		FunctionInterface interface1 = null;// String::charAt;
		int convert = interface1.convert("1234");
		System.out.println(convert);
	}

	@Test
	public void add() {
		Feature1 feature1 = new FeatureImpl();
		feature1.add(1, 2);
		feature1.jiafa(2, 3);
		feature1.chufa(2, 3);
		List<String> list = new ArrayList<String>();
		list.add("zhanghao");
		list.add("lishi");
		list.add("wangwu");
		list.add("zhaoliu");
		list.add("shunba");
		feature1.lambda(list);
		Collections.reverse(list);
		System.out.println(list);
		System.out.println("========================");
		Feature1 feature12 = (a, b) -> {
			long c = a + b;
			System.out.println("我被运行了");
			System.out.println("A+B=" + c);
		};
		feature12.chufa(12, 11);
	}

	@Test
	public void add1() {
		System.out.println(add(0.06, 0.01));
		System.out.println(sub(1.0, 0.42));
		System.out.println(4.015 * 100);
		System.out.println(303.1 / 1000);
	}

	public double add(double value1, double value2) {
		BigDecimal a = BigDecimal.valueOf(value1);
		BigDecimal b = new BigDecimal(value2);
		return a.add(b).doubleValue();
	}

	public double sub(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.subtract(b2).doubleValue();
	}
}
