package com.bjsxt.thread001;

public class MyThread extends Thread {
	private int count = 5;

	// synchronized加锁
	public synchronized void run() {
		count--;
		System.out.println(this.currentThread().getName() + " count = " + count);
	}

	public static void main(String[] args) {
        /**
         * 分析：当多个线程访问MyThread run方法时，以排队方式进行处理（这里排队是按照CPU分配的先后顺序�?定的�?
         * 1.尝试获得�?
         * 2.如果拿到锁，执行synchronized代码体内容，拿不到锁这个线程就会不断尝试获得这把锁，直到拿到为止
         *   而且是多个线程同时去竞争这把锁（也就会有锁竞争的问题�?
         * */		
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		Thread t4 = new Thread(myThread, "t4");
		Thread t5 = new Thread(myThread, "t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
