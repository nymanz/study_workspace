package demo0;

/**
 * @see LinkedList队列测试类(单线程和多线程)
 * @author Herman.Xiong
 * @since jdk 1.6
 * @date 2014年2月26日 11:58:10
 * @version V1.0
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListTest tm=new LinkedListTest();
		tm.test1();//只允许同时运行1个线程
		//tm.test5();//只允许同时运行5个线程
	}

	//只允许同时运行1个线程
	void test1(){
		//只允许同时运行1个线程
		WorkQueue workQueue = new WorkQueue(1);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			WorkThread wThread = new WorkThread();
			workQueue.execute(wThread);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//只允许同时运行5个线程
	void test5(){
		//只允许同时运行5个线程
		WorkQueue workQueue =new WorkQueue(5);
		for (int i = 0; i < 30; i++) {
			WorkThread wThread=new WorkThread();
			workQueue.execute(wThread);
		}
	}
}
