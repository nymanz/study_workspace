package demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @see demo1 ArrayBlockingQueue实例队列入口
 * @author Herman.Xiong
 * @date 2014年2月26日 15:59:29
 * @version V1.0
 * @since jdk 1.6
 */
public class ArrayBlockQueueTest {
	
	/**
	 * ArrayBlockingQueue
	 * 在构造时需要指定容量,并可以选择是否需要公平性,
	 * 如果公平参数被设置true,等待时间最长的线程会优先得到处理
	 * (其实就是通过将ReentrantLock设置为true来 达到这种公平性的:即等待时间最长的线程会先操作)。
	 * 通常,公平性会使你在性能上付出代价,只有在的确非常需要的时候再使用它。
	 * 它是基于数组的阻塞循环队列,此队列按 FIFO(先进先出)原则对元素进行排序。
	 */
	
	public static void main(String[] args) {
		ArrayBlockQueueTest test = new ArrayBlockQueueTest() ;
		test.main();
	}
	
	void main() {
		/**
		 * newCachedThreadPool
		 * -缓存型池子，先查看池中有没有以前建立的线程，如果有，就reuse(重用).如果没有，就建一个新的线程加入池中
		 * -缓存型池子通常用于执行一些生存期很短的异步型任务
		 * -因此在一些面向连接的daemon(守护进程)型SERVER中用得不多。
		 * -能reuse的线程，必须是timeout IDLE(空闲的)内的池中线程，
		 * -缺省timeout是60s,超过这个IDLE时长，线程实例将被终止及移出池。
		 * -注意，放入CachedThreadPool的线程不必担心其结束，超过TIMEOUT不活动，其会自动被终止。
		 */
		ExecutorService es = Executors.newCachedThreadPool() ;
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}

	void test0(){
		/**
		 * -newFixedThreadPool与cacheThreadPool差不多，也是能reuse就用，但不能随时建新的线程
		 * -其独特之处:任意时间点，最多只能有固定数目的活动线程存在，此时如果有新的线程要建立，
		 * -只能放在另外的队列中等待，直到当前的线程中某个线程终止直接被移出池子
		 * -和cacheThreadPool不同，FixedThreadPool没有IDLE机制（可能也有，但既然文档没提，肯定非常长，
		 * -类似依赖上层的TCP或UDP IDLE机制之类的），所以FixedThreadPool多数针对一些很稳定很固定的正规并发线程，多用于服务器
		 * -从方法的源代码看，cache池和fixed 池调用的是同一个底层池，只不过参数不同:
		 * -fixed池线程数固定，并且是0秒IDLE（无IDLE）cache池线程数支持0-Integer.MAX_VALUE(显然完全没考虑主机的资源承受能力），60秒IDLE  
		 */
		ExecutorService es = Executors.newFixedThreadPool(10);
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}
	
	void test1(){
		/**
		 * newScheduledThreadPool
		 * -调度型线程池
		 * -这个池子里的线程可以按schedule依次delay执行，或周期执行
		 */
		ExecutorService es = Executors.newScheduledThreadPool(10);
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}
	
	void test2(){
		/**
		 * newSingleThreadExecutor
		 * -单例线程，任意时间池中只能有一个线程
		 * -用的是和cache池和fixed池相同的底层池，但线程数目是1-1,0秒IDLE（无IDLE）
		 */
		ExecutorService es = Executors.newSingleThreadExecutor();
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}
}
