package demo1;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadGet extends Thread{
	ArrayBlockingQueue<String> abq = null ;
	
	public ThreadGet(ArrayBlockingQueue<String> abq) {
		this.abq = abq ;
	}
	
	public void run(){
		while (true) {
			try {
				//每隔十秒钟会进行拿数据出来的
				Thread.sleep(10000);
				System.err.println("我要从队列中取数据了");
				String msg = abq.remove();
				System.err.println("队列里面取得的数据是：" + msg + " 队列中还的数据个数还有的 ：" + abq.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
