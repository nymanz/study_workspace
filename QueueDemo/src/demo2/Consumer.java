package demo2;

/**
 * @see 定义苹果消费者
 * @author Herman.Xiong
 */
public class Consumer implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String instance;
    private Basket basket;

    public Consumer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    public void run() {
        try {
            while (true) {
                // 消费苹果
                System.out.println("消费者准备消费苹果：" + instance);
                System.out.println(basket.consume());
                System.out.println("!消费者消费苹果完毕：" + instance);
                // 休眠1000ms
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Consumer Interrupted");
        }
    }
}
