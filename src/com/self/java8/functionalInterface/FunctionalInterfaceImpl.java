/**
 * 
 */
package com.self.java8.functionalInterface;

import java.util.function.Function;

import com.self.java8.Person;

/**
 * @author Rajeshkumar
 *
 */
public class FunctionalInterfaceImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 37;
		
		MyFunctionalInterface primeCheck = num -> {
			
			if (n <= 1) 
	            return false; 
	       
	        // Check from 2 to n-1 
	        for (int i = 2; i < n; i++) 
	            if (n % i == 0) 
	                return false; 
	       
	        return true; 
		};

		System.out.println(n +" is Prime Number : "+primeCheck.test(n));
		
		Function<Person, Integer> ageMapper = Person::getAge;
		Person p1 = new Person("Rajeshkumar","Ganesan",30);
		System.out.println("Person Age is "+ageMapper.apply(p1));
	}

}
