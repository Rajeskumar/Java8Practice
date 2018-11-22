/**
 * 
 */
package com.self.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Rajeshkumar
 * @param <T>
 *
 */
public class PersonComparator{

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		
		Person p1 = new Person("Rajeshkumar","Ganesan",30);
		Person p2 = new Person("Ganesan","Muthusamy",70);
		Person p4 = new Person("Ramya","Ganesan",27);
		Person p3 = new Person("Jegathambal","Ganesan",53);
		Person p5 = new Person("Ramya","A",23);
		Person p6 = new Person("Ramya","A",35);
		
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p5);
		personList.add(p6);
//		System.out.println(personList.toString());
		Collections.sort(personList, (person1,person2) -> 
		{ 
			if(person1.getFirstName().equalsIgnoreCase(person2.getFirstName())) {
				if(person1.getLastName().equalsIgnoreCase(person2.getLastName())) {
					return person1.getAge()-person2.getAge();
				}else {
					return person1.getLastName().compareTo(person2.getLastName());
				}
			}else {
				return person1.getFirstName().compareTo(person2.getFirstName());
			}
			
			});
		
		personList.sort(Comparator.comparing(Person::getFirstName));
		System.out.println(personList.toString());
	
}
}
