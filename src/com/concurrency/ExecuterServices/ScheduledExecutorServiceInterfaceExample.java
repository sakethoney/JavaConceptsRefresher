package com.concurrency.ExecuterServices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceInterfaceExample {
	private static final int NOOFTHREADS = 5;
	private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(NOOFTHREADS);
	
	static Runnable task = new Runnable(){
		public void run(){
			String threadName = Thread.currentThread().getName();
			System.out.println("task exeucted by thread "+threadName);
		}
	};
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try{
			/*
			 * Task will be executed by 1 of the 5 Thread object available in the Pool as per schedule
			 * can return  a value also,
			 */
			ScheduledFuture<?> schFutureStr = scheduledExecutorService.schedule(task,5,TimeUnit.SECONDS);
			System.out.println(schFutureStr.get());
		}finally{
			scheduledExecutorService.shutdown();
		}
	}
}
