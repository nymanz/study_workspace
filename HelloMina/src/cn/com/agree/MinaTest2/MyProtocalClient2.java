package cn.com.agree.MinaTest2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
/**
 * MyProtocalClient2是自己创建的客户端类
 * @author 赵乾泽
 *
 */
public class MyProtocalClient2 {
	private static final String HOST = "127.0.0.1";  
    private static final int PORT = 2500;  
    static long counter = 0;  
    final static int FC1 = 10;  
    static long start = 0;  
    private static Scanner sc = new Scanner(System.in);
    /** 
     * 使用Mina的框架结构进行测试 
     *  
     * @param args 
     */  
    public static void main(String[] args) throws IOException {  
        start = System.currentTimeMillis();  
        IoConnector connector = new NioSocketConnector();  
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyProtocalCodecFactory(Charset.forName("UTF-8"))));  
        connector.setHandler(new TimeClientHandler2());  
        connector.getSessionConfig().setReadBufferSize(10240);  
        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);   
        ConnectFuture connFuture = connector.connect(new InetSocketAddress(HOST, PORT));  
        //添加监听器
        connFuture.addListener(new IoFutureListener<ConnectFuture>() {  
            public void operationComplete(ConnectFuture future) {  
                try {  
                    if (future.isConnected()) {  
                        IoSession session = future.getSession();   
                        sendData(session);    
                    } else {  
                        System.out.println("连接不存在 ");  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
        System.out.println("start client ...");  
    }  
    public static void sendData(IoSession session) throws IOException {  
        for (int i = 0; i < FC1; i++) {  
        	String msg = "成功";
            String content = "测试" + i+"："+msg;  
            MyProtocalPack pack = new MyProtocalPack((byte) i, content);  
            session.write(pack);  
            System.out.println("send data:" + pack);  
        }  
    }  
}  

class TimeClientHandler2 extends IoHandlerAdapter {  
	
    @Override  
    public void sessionOpened(IoSession session) {  
        // Set reader idle time to 10 seconds.  
        // sessionIdle(...) method will be invoked when no data is read  
        // for 10 seconds.  
    	System.out.println("Client：sessionOpened");
        session.getConfig().setIdleTime(IdleStatus.READER_IDLE, 60);  
    }  
    @Override  
    public void sessionClosed(IoSession session) {  
        // Print out total number of bytes read from the remote peer.  
    	System.out.println("Client：sessionClosed");
        System.err.println("Total " + session.getReadBytes() + " byte(s)");  
    }  
    @Override  
    public void sessionIdle(IoSession session, IdleStatus status) {  
        // Close the connection if reader is idle. 
    	System.out.println("Client：sessionIdle");
        if (status == IdleStatus.READER_IDLE) {  
            session.close(true);  
        }  
    }  
    @Override  
    public void messageReceived(IoSession session, Object message) {  
       System.out.println("Client：messageReceived");
    	MyProtocalPack pack = (MyProtocalPack) message;  
        System.out.println("rec:" + pack);  
    }
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：sessionCreated");
		super.sessionCreated(session);
	}
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：exceptionCaught");
		super.exceptionCaught(session, cause);
	}
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：messageSent");	
		System.out.println("Client：messageSent：success");
	}
	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：inputClosed");
		super.inputClosed(session);
	}  
}
