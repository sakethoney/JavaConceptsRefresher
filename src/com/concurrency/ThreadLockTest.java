package com.concurrency;

public class ThreadLockTest {

	public static void main(String[] args) {
		Counter counterObject = new Counter();
		ThreadFactory A = new ThreadFactory(counterObject);
		A.setName("ThreadA");
		ThreadFactory B = new ThreadFactory(counterObject);
		B.setName("ThreadB");
		ThreadFactory C = new ThreadFactory(counterObject);
		C.setName("ThreadC");
		ThreadFactory D = new ThreadFactory(counterObject);
		D.setName("ThreadD");
		ThreadFactory E = new ThreadFactory(counterObject);
		E.setName("ThreadE");
		ThreadFactory F = new ThreadFactory(counterObject);
		F.setName("ThreadF");
		
		A.start();
		B.start();
		C.start();
		D.start();
		E.start();
		F.start();
		System.out.println("Exiting the main of the ThreadLock");
	}
}
