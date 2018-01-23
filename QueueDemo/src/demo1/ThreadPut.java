package demo1;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPut extends Thread{
	private ArrayBlockingQueue<String> abq = null ;
	public ThreadPut (ArrayBlockingQueue<String> abq) {
		this.abq = abq ;
	}
	public void run() {
		while (true) {
			try {
				System.out.println("我要向队列里面存放数据了");
				//每隔5秒会向队列里放一次数据
				Thread.sleep(5000) ;
				//向队列里面存放数据
				abq.put("1") ;
				System.out.println("当前的队列里面存放的数据的个数是：" + abq.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
