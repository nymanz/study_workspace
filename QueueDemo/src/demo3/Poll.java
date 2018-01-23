package demo3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @see 消费
 * @author Herman.Xiong
 *
 */
public class Poll implements Runnable{
	private ConcurrentLinkedQueue<Integer> queue=null;
	private CountDownLatch latch=null;
	
	public Poll(ConcurrentLinkedQueue<Integer> queue,CountDownLatch latch){
		this.queue=queue;
		this.latch=latch;
	}
	
	public void run() {
		/*看了下ConcurrentLinkedQueue的API原来.size()
		是要遍历一遍集合的，难怪那么慢，
		所以尽量要避免用size而改用isEmpty().*/
		/*while (queue.size()>0) {
			System.out.println(queue.poll());
		}
		latch.countDown();*/
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        latch.countDown();
    }
}
