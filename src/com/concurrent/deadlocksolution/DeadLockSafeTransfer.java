package com.concurrent.deadlocksolution;

public class DeadLockSafeTransfer {
	public static void main(String[] args) throws InterruptedException{
		final AccountSafeLock Account1 = new AccountSafeLock();
		Account1.setBalance(8000);
		final AccountSafeLock Account2 = new AccountSafeLock();
		Account2.setBalance(5000);
		new Thread(new Runnable(){
			public void run(){
				double transferAmt = 1000;
				System.out.println("Thread A => Transfer from 1 to 2:"+transferAmt);
				Account1.transfer(Account2, transferAmt);
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){
				double transferAmt = 2000;
				System.out.println("Thread B => Transfer from 2 to 1:"+transferAmt);
				Account2.transfer(Account1, transferAmt);
			}
		}).start();
		Thread.sleep(1000);
		System.out.println("balance of Account1: "+Account1.getBalance() );
		System.out.println("balance of Account2: "+Account2.getBalance() );
	}
}
