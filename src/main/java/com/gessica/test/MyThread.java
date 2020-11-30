package com.gessica.test;

public class MyThread implements Runnable {
	private String tag;
	private Object lock;
	private Object lock2;
	public MyThread(String tag,Object lock,Object lock2) {//c,a
		this.tag =tag;
		this.lock = lock;
		this.lock2 = lock2;
	}
	@Override
	public void run() {
		int count = 5;
		while(count>0){
			synchronized (lock) {
				synchronized (lock2) {
					System.out.print(tag);//A打印
					count--;
					lock2.notifyAll();
				}
				try {
					if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
						lock.notifyAll();
                    } else {
                    	lock.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                    }
				} catch (InterruptedException e) {
					System.out.println("A"+e.toString());
				}
			}
		}
	}

}
