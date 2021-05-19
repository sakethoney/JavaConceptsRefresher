package com.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TwoCyclicBarriersExample {
	
	
	// Runnable task for each thread
	private static class Task1 implements Runnable {
		private CyclicBarrier barrier1;
		private CyclicBarrier barrier2;

		public Task1(CyclicBarrier barrier1, CyclicBarrier barrier2) {
			this.barrier1 = barrier1;
			this.barrier2 = barrier2;
		}

		public void run() {
			try {
				System.out.println(Thread.currentThread().getName()
						+ "Waiting on 1st barrier point");
				barrier1.await();
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()
						+ "Waiting on 2nd barrier point");
				barrier2.await();
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()
						+ " Crossed all the barrier points");

			} catch (InterruptedException ix) {} 
			  catch (BrokenBarrierException bx) {}
			}
		}
	public static void main(String args) throws Exception {
		Runnable barrierAction1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("All threads reached the barrier 1");

			}
		};
		Runnable barrierAction2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("All threads reached the barrier 2");

			}
		};
		// creating Cyclicbarrier for two threads
		CyclicBarrier barrier1 = new CyclicBarrier(2, barrierAction1);
		// creating Cyclicbarrier for two threads
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrierAction2);

		Thread thread1 = new Thread(new Task1(barrier1, barrier2), "Thread1");
		Thread thread2 = new Thread(new Task1(barrier1, barrier2), "Thread2");
		thread1.start();
		thread1.sleep(2000);
		thread1.start();

	}
}
