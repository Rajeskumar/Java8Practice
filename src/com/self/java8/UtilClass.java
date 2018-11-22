/**
 * 
 */
package com.self.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rajesh
 *
 */
public class UtilClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintMessage msg = s->System.out.print("Hi "+s);
		PrintMessage msg1 = System.out::print;
		msg.prntmsg(90);
		msg1.prntmsg(90);
		msg1.printhello("Ganesan");
	}

interface PrintMessage {
	void prntmsg(int s);
	default void printhello(String s0) {
		System.out.println("Default Method Print :"+s0);
	}
}

}

