/**
 * 
 */
package com.self.jsonPractice;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * @author Rajeshkumar
 *
 */
public class JsonConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee emp = new Employee("Rajeshkumar","Ganesan",30,74000);
		Employee emp1 = new Employee("Praveenkumar","Saravanan",32,100000);
		
		Employer employer = new Employer("Cognizant","United States","New York");
		Employer employer1 = new Employer("SAP","United States","California");
		
		emp.setEmployer(employer);
		emp1.setEmployer(employer1);
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(emp);
		empList.add(emp1);
		JSONObject jo = new JSONObject(emp);
		
		JSONArray arr = new JSONArray(empList);
		
		JSONTokener token = new JSONTokener("Rajesh");
		try {
		while(token.more()) {
			System.out.println(token.next());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(jo.toString());
		System.out.println(arr.toString());
	}

}
