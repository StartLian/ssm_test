package com.gessica.arithmetic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.cnblogs.com/gemine/p/9039012.html
 * @author 廉吉鹏
 * @date2020年11月28日下午3:36:33
 * TODO
 */
public class Cycle_ABC_Condition {
	Condition A,B,C;
	Lock lock;
	int state;
	Cycle_ABC_Condition(Lock lock,Condition A,Condition B,Condition C){
		this.A =A;
		this.B =B;
		this.C =C;
		this.lock =lock;
	}
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition newConditionA = lock.newCondition();
		Condition newConditionB = lock.newCondition();
		Condition newConditionC = lock.newCondition();
		Cycle_ABC_Condition cycle_ABC_Condition = new Cycle_ABC_Condition(lock, newConditionA, newConditionB, newConditionC);
		cycle_ABC_Condition.new ThreadA().start();
		cycle_ABC_Condition.new ThreadB().start();
		cycle_ABC_Condition.new ThreadC().start();
	}
	public class ThreadA extends Thread{
		@Override
		public void run() {
			while (state<30) {
				try {
					lock.lock();
					while (state%3 ==0) {
						try {
							System.out.print("A");
							A.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					state++;
					B.signal();
				} finally {
					lock.unlock();
				}
			}
		}
	}
	public class ThreadB extends Thread{
		@Override
		public void run() {
			while (state<30) {
				try {
					lock.lock();
					while (state%3 ==1) {
						try {
							System.out.print("B");
							B.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					state++;
					C.signal();
				} finally {
					lock.unlock();
				}
			}
		}
	}
	public class ThreadC extends Thread{
		@Override
		public void run() {
			while (state<30) {
				try {
					lock.lock();
					while (state%3 ==2) {
						try {
							System.out.print("C");
							C.await();//当前线程会释放锁并在此等待
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					state++;
					A.signal();//释放那个信号
				} finally {
					lock.unlock();
				}
			}
		}
	}

}
