package demo0;

import java.util.LinkedList;
/**
 * @author Herman.Xiong
 * @see 多线程或单线程去队列队首请求
 * @date 2014年2月26日 11:53:46
 * @version V1.0
 * @since Jdk1.6
 */
@SuppressWarnings({"unused","unchecked"})
public class WorkQueue{

    private final int nThreads;//同时最多执行的线程个数
    private final PoolWorker[] threads;//线程池
    private final LinkedList queue;//线程队列

    public WorkQueue(int nThreads)
    {
        this.nThreads = nThreads;
        queue = new LinkedList();
        threads = new PoolWorker[nThreads];
        for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable r) {
        synchronized(queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    /**
     * @同步去取队首对象
     * @author Herman.Xiong
     * @date 2014年2月26日 11:55:16
     */
    private class PoolWorker extends Thread {
        @Override
        public void run() {
            Runnable r;
            while (true) {
                synchronized(queue) {
                    while (queue.isEmpty()) {
                        try{
                            queue.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    r = (Runnable) queue.removeFirst();
                }
                try {
                    r.run();
                }catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

