/**
 * 
 */
package com.self.java8.mapFilters;

import java.util.ArrayList;
import java.util.List;

import com.self.java8.Person;

/**
 * @author Rajeshkumar
 *
 */
public class MapFilterPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person p1 = new Person("Rajesh","Ganesan",30);
		Person p2 = new Person("Ramesh","Kumar",28);
		Person p3 = new Person("Rakesh","Kanna",18);
		Person p4 = new Person("Dhanush","kumar",19);
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		
		personList.removeIf(person->person.getAge()<20);
		
		System.out.println(personList.toString());

	}

}
