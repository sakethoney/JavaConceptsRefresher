package com.objectorientation.immutable;

public class ImmutableCustomer {
	private final String firsName;
	private final String lastName;
	public ImmutableCustomer(String fname, String lname){
		this.firsName=fname;
		this.lastName=lname;
	}
	public String getFirsName() {
		return firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFullName(){
		return firsName+""+lastName;
	}
	public static void main(String[] args) {
		ImmutableCustomer customer1 = new ImmutableCustomer("Saket", "Komal");
		System.out.println(customer1.getFullName());
	}
}
