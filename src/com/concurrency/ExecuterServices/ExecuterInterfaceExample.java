package com.concurrency.ExecuterServices;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecuterInterfaceExample {
	
	private static final int NOOFTHREADS = 5;
	private static final Executor executor = Executors.newFixedThreadPool(NOOFTHREADS);
	
	static Runnable task = new Runnable(){
		public void run(){
			String threadName = Thread.currentThread().getName();
			System.out.println("task exeucted by thread "+threadName);
		}
	};
	public static void main(String[] args) {
		try{
			executor.execute(task);
		}finally{
			// no shutdown method for the Executor interface
		}
	}
}
