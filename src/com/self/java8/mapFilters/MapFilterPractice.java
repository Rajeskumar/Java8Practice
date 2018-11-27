/**
 * 
 */
package com.self.java8.mapFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		
//		personList.removeIf(person->person.getAge()<20);
		
		//stream(), filter()
		personList.stream().map(person->person.getAge()).filter(age->age<20).forEach(System.out::println);
		
		//Skip() and limit()
		personList.stream().skip(2).limit(1).filter(person->person.getAge()<20).forEach(System.out::println);
		
		//findfirst(), findAny()
		Optional<Person> opt = personList.stream().findAny();
		System.out.println(opt.toString());
		
		//iterate() and generate()
		Stream<String> stream1 = Stream.generate(()-> "Raj"); // this is not limited so its infinite.
		stream1.limit(5).forEach(System.out::println); //Limiting here to 5.
		
		Stream<String> stream2 = Stream.iterate("+", s->s+"+");
		stream2.limit(5).forEach(System.out::println); //Limiting here to 5.

		//Random Number generated.
		IntStream inStream = ThreadLocalRandom.current().ints();
		inStream.limit(5).forEach(System.out::println);
	}

}
