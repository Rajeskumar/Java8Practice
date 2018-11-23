/**
 * 
 */
package com.self.java8.mapFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author Rajeshkumar
 *
 */
public class MainReduction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		List<Integer> list1 = Arrays.asList(0,1,2,3,4);
		List<Integer> list2 = Arrays.asList(5,6,7,8,9);

		BinaryOperator<Integer> op = (item1,item2)->item1+item2;
		
		int reduction = reduce(list1,0,op) + reduce(list2,0,op);
		System.out.println(reduction);
	}

	private static int reduce(List<Integer> list, int i, BinaryOperator<Integer> op) {
		
		int result = i;
		
		for(int item:list) {
			result = op.apply(result, item);
		}
		
		return result;
	}

}
