package org.zhanghao.java8.feature;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
public interface Feature1 {
	public default void  add(int a,int b) {
		System.out.println(a+"+"+b+"="+(a+b));
	}
	
	public default void  jiafa(long a,long b) {
		System.out.println(a+"-"+b+"="+(a+b));
	}
	
	public default void  nolambda(List<String> list) {
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});
		System.out.println(list);
	}
	
	public default void  lambda(List<String> list) {
		Collections.sort(list, (a,b)->a.compareTo(b));
	}
	
	public  void  chufa(long a,long b) ;
}
