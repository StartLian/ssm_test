package com.gessica.arithmetic.thread;

public class Cycle_ABC_Synchronized implements Runnable {
	String Tag;
	Object other;
	Object self;
	
	public Cycle_ABC_Synchronized(String Tag,Object other,Object self){
		this.Tag =Tag;
		this.other =other;
		this.self =self;
	}
	@Override
	public void run() {
		int count =10;
		while (count>0) {
			synchronized (other) {
				synchronized (self) {
					count--;
					System.out.print(Tag);
					self.notifyAll();//让其他线程竞争锁，自己还没释放锁，只等到同步代码块执行完才释放
				}
				try {
					if (count==0) {
						other.notifyAll();
					}else {
						other.wait();//让第三条线程阻塞,只有线程二可以获取到锁
					}
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
			}
		}
	}
//	@Override
//	public void run() {
//		while (true) {
//			synchronized (other) {
//				synchronized (self) {
//					System.out.print(Tag);
//					self.notifyAll();//让其他线程竞争锁，自己还没释放锁，只等到同步代码块执行完才释放
//				}
//				try {
//					other.wait();//让第三条线程阻塞,只有线程二可以获取到锁
//				} catch (InterruptedException e) {
//					System.out.println(e.toString());
//				}
//			}
//		}
//	}

	public static void main(String[] agrs) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Cycle_ABC_Synchronized threadA = new Cycle_ABC_Synchronized("A", c, a);
		Cycle_ABC_Synchronized threadB = new Cycle_ABC_Synchronized("B", a, b);
		Cycle_ABC_Synchronized threadC = new Cycle_ABC_Synchronized("C", b, c);
		new Thread(threadA).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("mian->"+e);
		}
		new Thread(threadB).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("mian->"+e);
		}
		new Thread(threadC).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("mian->"+e);
		}
	}
}
