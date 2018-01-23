package demo2;


/**
 * @see 定义苹果生产者
 * @author Herman.Xiong
 */
public class Producer implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String instance;
    private Basket basket;

    public Producer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    public void run() {
        try {
            while (true) {
                // 生产苹果
                System.out.println("生产者准备生产苹果：" + instance);
                basket.produce();
                System.out.println("!生产者生产苹果完毕：" + instance);
                // 休眠300ms
                Thread.sleep(300);
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer Interrupted");
        }
    }
}
