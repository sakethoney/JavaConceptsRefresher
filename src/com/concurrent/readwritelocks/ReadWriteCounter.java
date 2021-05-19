package com.concurrent.readwritelocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ReadWriteCounter {

	private int counter = 0;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock	readLock	= lock.readLock();
	private final Lock  writeLock	= lock.writeLock();
	
	public int getCounter(){
		readLock.lock();
		try{
			return counter;
		}finally{
			readLock.unlock();
		}
	}
	public void incrementCounter(){
		writeLock.lock();
		try{
			counter++;
		}finally{
			writeLock.unlock();
		}
	}
	
}
