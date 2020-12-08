package com.gessica.arithmetic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool_Condition {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public static void main(String[] args) {
		ThreadPool_Condition pool_Condition = new ThreadPool_Condition();
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		threadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				pool_Condition.conditionawait();
				
			}
		});
		threadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				pool_Condition.conditionSignal();
			}
		});

	}
	protected void conditionSignal() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "拿到锁了");
			System.out.println(Thread.currentThread().getName() + "等待信号");
			condition.signal();
			System.out.println(Thread.currentThread().getName() + "拿到信号");
			System.out.println(Thread.currentThread().getName() + "生产一头猪");
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}
	protected  void conditionawait() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "拿到锁了");
			System.out.println(Thread.currentThread().getName() + "等待信号");
			condition.await();
			System.out.println(Thread.currentThread().getName() + "拿到信号");
			System.out.println(Thread.currentThread().getName() + "做成猪肉火腿");
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}

}
