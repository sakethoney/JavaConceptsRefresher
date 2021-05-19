package com.concurrency.ExecuterServices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceInterfaceExample {

	private static final int NOOFTHREADS = 5;
	private static final ExecutorService executorService = Executors.newFixedThreadPool(NOOFTHREADS);
	
	static Runnable task = new Runnable(){
		public void run(){
			String threadName = Thread.currentThread().getName();
			System.out.println("task exeucted by thread "+threadName);
		}
	};
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try{
			Future futureStr = executorService.submit(task);
			System.out.println(futureStr.get());
		}finally{
			executorService.shutdown();
		}
	}
}
