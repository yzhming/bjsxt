package com.bjsxt.base.sync005;

public class SyncDubbo2 {

	public synchronized void method1() {
		System.out.println("methord1..");
		method2();
	}

	public synchronized void method2() {
		System.out.println("methord2..");
		method3();
	}

	public synchronized void method3() {
		System.out.println("methord3..");
	}

	public static void main(String[] args) {
		final SyncDubbo2 sd = new SyncDubbo2();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				sd.method1();

			}
		});
		t1.start();
	}

}
