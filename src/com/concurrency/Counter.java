package com.concurrency;

public class Counter {

	private static int classCounter = 0;
	private  int objectCounter = 0;
	public static synchronized void incrementClassCounter(){
		classCounter++;
	}
	public static synchronized void decrementClassCounter(){
		classCounter--;
	}
	public static void displayClassCounter(){
		System.out.println("class counter : "+ classCounter);
	}
	public synchronized void increment(){
		objectCounter++;
	}
	public synchronized void decrement(){
		objectCounter--;
	}
	public void display(){
		System.out.println("Object Counter : "+objectCounter);
	}
}
