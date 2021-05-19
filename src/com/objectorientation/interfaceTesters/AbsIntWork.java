package com.objectorientation.interfaceTesters;

public abstract class AbsIntWork implements APIInterface{
	
	int noOfAttempts = 0;
	
	AbsIntWork(){
		System.out.println("Abstract constructor");
		
	}
	
	private AbsIntWork(int noOfAttempts){
	
		System.out.println("Abstract explicit constructor");
		this.noOfAttempts = noOfAttempts;
	}

	abstract int  doWork();
}
