package demo0;


/**
 * @see 处理取出队列数据后的业务逻辑
 * @author Herman.Xiong
 * @date 2014年2月26日 11:56:56
 * @version V1.0
 * @since jdk 1.6
 */
public class WorkThread extends Thread{
	public static int number = 0;
	public void run() {
		try {
			number = number + 1;
			Thread.sleep(100);
			System.out.println("number = "+number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

