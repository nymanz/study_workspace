package demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {
	/**
	 * LinkedBlockingQueue的容量是没有上限的
	 * (说的不准确，在不指定时容量为Integer.MAX_VALUE，不要然的话在put时怎么会受阻呢)，
	 * 但是也可以选择指定其最大容量，它是基于链表的队列，此队列按 FIFO(先进先出)排序元素。
	 * 由于LinkedBlockingQueue实现是线程安全的，实现了先进先出等特性，
	 * 是作为生产者消费者的首选，LinkedBlockingQueue 可以指定容量，也可以不指定，
	 * 不指定的话，默认最大是Integer.MAX_VALUE，其中主要用到put和take方法，
	 * put方法在队列满的时候会阻塞直到有队列成员被消费，
	 * take方法在队列空的时候会阻塞，直到有队列成员被放进来。
	 */
	public static void main(String[] args) {
		BlockingQueueTest test=new BlockingQueueTest();
		test.test0();
	}
	
	void test0(){
		// 建立一个装苹果的篮子
        Basket basket = new Basket();
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer("生产者001", basket);
        Producer producer2 = new Producer("生产者002", basket);
        Consumer consumer = new Consumer("消费者001", basket);
        service.submit((producer));
        service.submit(producer2);
        service.submit(consumer);
        // 程序运行50s后，所有任务停止
        try {
            Thread.sleep(1000 * 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
	}
}
