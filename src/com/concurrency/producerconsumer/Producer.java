package com.concurrency.producerconsumer;

import java.util.Random;

public class Producer implements Runnable{
	private Drop drop;
	public Producer(Drop drop){
		this.drop=drop;
	}
	public void run(){
		String importantInfo[]={
				"First string message",
				"Second string message",
				"Third string message",
				"Fourth String message"
		};
		Random random = new Random();
		for(int i=0; i<=importantInfo.length; i++){
			drop.put(importantInfo[i]);
			try{
				Thread.sleep(random.nextInt(50000));
			}catch(InterruptedException e){}
		}
		drop.put("DONE");
	}
}
