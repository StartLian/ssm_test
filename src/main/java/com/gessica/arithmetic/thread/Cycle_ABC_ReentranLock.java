package com.gessica.arithmetic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cycle_ABC_ReentranLock {
	Lock lock ;
	static int state;
	public Cycle_ABC_ReentranLock(Lock lock) {
		this.lock = lock;
	}
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Cycle_ABC_ReentranLock abc_ReentranLock  = new Cycle_ABC_ReentranLock(lock);
		new Thread( abc_ReentranLock.new ThreadA()).start();
		new Thread( abc_ReentranLock.new ThreadB()).start();
		new Thread( abc_ReentranLock.new ThreadC()).start();
	}
	public class ThreadA implements  Runnable{
		@Override
		public void run() {
			while (state<30) {
				try{
					lock.lock();
					while (state%3 == 0) {//state ==0 ==3
						System.err.print("A");
						state++;
					}
				}finally {
					lock.unlock();
				}
			}
		}
	}
	public class ThreadB implements  Runnable{
		@Override
		public void run() {
			while (state<30) {
				try{
					lock.lock();
					while (state%3 == 1) {//state ==1 ==4...
						System.err.print("B");
						state++;
					}
				}finally {
					lock.unlock();
				}
			}
		}
	}
	public class ThreadC implements  Runnable{
		@Override
		public void run() {
			while (state<31) {
				try{
					lock.lock();
					while (state%3 == 2) {//state ==2 ==5..
						System.err.print("C");
						state++;
					}
				}finally {
					lock.unlock();
				}
			}
		}
	}

}
