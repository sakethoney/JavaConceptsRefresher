package com.concurrency.explicitlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

public class ReentrantLockTest {

	public static void main(String[] args) {
		Lock lock	=	new ReentrantLock();
		lock.lock();// block until condition holds
		try{
			//access the resource protected by this lock
		}finally{
			lock.unlock();
		}
	}
}
