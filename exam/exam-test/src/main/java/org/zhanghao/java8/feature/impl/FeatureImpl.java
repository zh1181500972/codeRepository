package org.zhanghao.java8.feature.impl;

import org.zhanghao.java8.feature.Feature1;

public class FeatureImpl implements Feature1 {

	@Override
	public void chufa(long a, long b) {
		// TODO Auto-generated method stub
		System.out.println(a+"/"+b+"="+(a*1.0/b));
	}
	

}
