package com.concurrency;

public class ThreadFactory extends Thread{

	private Counter counterObject;
	
	public ThreadFactory(Counter counterObject){
		this.counterObject = counterObject;
	}
	
	public void run(){
		String threadName = this.getName();
		if(threadName.equals("ThreadA")){
			counterObject.incrementClassCounter();
		}else if(threadName.equals("ThreadB")){
			counterObject.decrementClassCounter();
		}else if(threadName.equals("ThreadC")){
			counterObject.displayClassCounter();
		}else if(threadName.equals("ThreadD")){
			counterObject.increment();
		}else if(threadName.equals("ThreadE")){
			counterObject.decrement();
		}else if(threadName.equals("ThreadF")){
			counterObject.display();
		}
	}
}
