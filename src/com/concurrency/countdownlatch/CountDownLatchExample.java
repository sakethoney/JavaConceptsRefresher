package com.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatchExample latchex = new CountDownLatchExample();
		CountDownLatch latch = new CountDownLatch(2);
		
		Waiting waiting = latchex.new Waiting(latch);
		Decreasing decreasing = latchex.new Decreasing(latch);
		
		new Thread(waiting).start();
		new Thread(decreasing).start();
	}
	
	private class Waiting implements Runnable{
		CountDownLatch latch = null;
		public Waiting(CountDownLatch latch){
			this.latch = latch;
		}
		public void run(){
			try{
				System.out.println("Start waiting inside thread");
				latch.await();
			}catch(InterruptedException ix){}
			System.out.println("Wait is over");
		}
	}
	private class Decreasing implements Runnable{
		CountDownLatch latch = null;
		public Decreasing(CountDownLatch latch){
			this.latch = latch;
		}
		public void run(){
			try{
				Thread.sleep(2000);
				System.out.println("Decreasing first");
				latch.countDown();
				
				Thread.sleep(2000);
				System.out.println("Decreasing second");
				latch.countDown();
			}catch(InterruptedException ix){}
			System.out.println("Countdown is over");
		}
		
	}
}
