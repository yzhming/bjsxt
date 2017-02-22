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
		 * ������ t1 �߳��ȳ���object�����lock����t2�߳̿����첽�ķ�ʽ���ö����еķ�synchronized���εķ��� t1
		 * �߳��ȳ���object�����lock����t2�߳�������ʱ����ö����е�ͬ����synchronized����������ȴ���Ҳ����ͬ��
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
