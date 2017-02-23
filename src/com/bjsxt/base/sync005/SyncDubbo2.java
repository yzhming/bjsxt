package com.bjsxt.base.sync005;

public class SyncDubbo2 {
	
	static class Main{
		public int i = 10;  
		   public synchronized void operationSup() throws InterruptedException{
			   i--;
			   System.out.println("Main print i = " + i);
			   Thread.sleep(1000);
		   }
	}
	
	static class Sub extends Main{
		   public synchronized void operationSub() throws InterruptedException{
			 while(i > 0){
				 i--;
				 System.out.println("Sub print i = " + i);
				 Thread.sleep(1000);
				 this.operationSup();
			 }
		   }
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sub sub = new Sub();
				try {
					sub.operationSub();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
	}
}
