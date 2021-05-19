package com.concurrent.deadlocksolution;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountSafeLock {
	double balance;
	public final Lock lock = new ReentrantLock();
	
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public void withdraw(double amount){
		balance = balance - amount;
	}
	public void deposit(double amount)
	{
		balance = balance+amount;
	}
	public boolean accquireLocks(AccountSafeLock targetAcc){
		Boolean myLock  = false;
		Boolean otherLock = false;
		try{
			myLock = this.lock.tryLock();
			otherLock = targetAcc.lock.tryLock();
		}finally{
			if(!(myLock && otherLock)){
				if(myLock){
					this.lock.unlock();
				}
				if(otherLock){
					targetAcc.lock.unlock();
				}
			}
		}
		return myLock && otherLock;
	}
	public void transfer (AccountSafeLock tragetAcc, double transferAmount){
		if(accquireLocks(tragetAcc)){
			try{
				this.withdraw(transferAmount);
				tragetAcc.deposit(transferAmount);
			}finally{
				this.lock.unlock();
				tragetAcc.lock.unlock();
			}
		}else{
			System.out.println("Transfer Failed!! try again");
		}
	}
}
