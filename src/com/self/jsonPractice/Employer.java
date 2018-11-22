/**
 * 
 */
package com.self.jsonPractice;

/**
 * @author Rajeshkumar
 *
 */
public class Employer {

	private String name;
	private String country;
	private String state;
	
	public Employer (String name, String country, String state) {
		this.name = name;
		this.country = country;
		this.state = state;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}
