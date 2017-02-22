package com.bjsxt.thread003;

public class MyObject {

	public synchronized void method1() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  synchronized void method2() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {

		final MyObject mo = new MyObject();

		/**
		 * 分析： t1 线程先持有object对象的lock锁，t2线程可以异步的方式调用对象中的非synchronized修饰的方法 t1
		 * 线程先持有object对象的lock锁，t2线程如果这个时候调用对象中的同步（synchronized）方法则需等待，也就是同步
		 */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method1();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method2();
			}
		});
		t1.start();
		t2.start();
	}

}
