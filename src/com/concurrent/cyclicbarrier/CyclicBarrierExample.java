package com.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	//runnable task for each thread
	private static class Task implements Runnable{
		private CyclicBarrier barrier;
		public Task(CyclicBarrier barrier){
			this.barrier=barrier;
		}
		public void run(){
			try{
				System.out.println(Thread.currentThread().getName()+"waiting on barrier point");
				barrier.await();
				System.out.println(Thread.currentThread().getName()+" Crossed Barrier point");
			}catch(InterruptedException ix){}
			 catch(BrokenBarrierException ex){}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Runnable barrierAction= new Runnable(){
			public void run(){
				System.out.println("All threads reached the barrier");
			}
		};
		//creating CyclicBarrier for 3 threads
		CyclicBarrier barrier = new CyclicBarrier(3,barrierAction);
		Thread thread1 = new Thread(new Task(barrier),"thread1");
		Thread thread2 = new Thread(new Task(barrier),"thread2");
		Thread thread3 = new Thread(new Task(barrier),"thread3");
		
		thread1.start(); thread1.sleep(1000);
		thread2.start(); thread2.sleep(2000);
		thread3.start();
	}
}
