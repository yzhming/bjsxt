package com.bjsxt.thread002;

public class MultiThread {

	private static int num = 0;

	public static synchronized void printNum(String tag) {

		if (tag.equals("a")) {
			num = 100;
			System.out.println("tag a,set num over!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			num = 200;
			System.out.println("tag b,set num over!");
		}

		System.out.println("tag" + tag + ", num = " + num);
	}

	public static void main(String[] args) {

		// 两个不同的对象
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				m1.printNum("a");

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				m2.printNum("b");

			}
		});
		t1.start();
		t2.start();
	}

}
