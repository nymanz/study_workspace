package cn.com.agree.MinaTest;

import java.net.InetSocketAddress;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionInitializationException;
import org.apache.mina.core.session.IoSessionInitializer;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
/**
 * UDP结构的客户端架构
 * @author 赵乾泽
 *
 */
public class UdpClient {
	private static IoSession session = null;

	public static void main(String[] args) {
		NioDatagramConnector connect = new NioDatagramConnector();
		connect.setHandler(new UDPClientHandler());
		try {
			ConnectFuture future = connect.connect(new InetSocketAddress(
					"127.0.0.1", 9234));
			future.awaitUninterruptibly();
			session = future.getSession();
			// 增加连接建立完成后的监听器。
			// 若在建立完成后才添加监听器，监听器将马上执行
			future.addListener(new IoFutureListener<ConnectFuture>() {
				public void operationComplete(ConnectFuture future) {
					if (future.isConnected()) {
						try {
							initSession(session, future, null);
							sendData();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println(("Not connected...exiting"));
					}
				}
			});
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.getCloseFuture().awaitUninterruptibly();
			}
		}
		connect.dispose();
	}

	protected final static void initSession(IoSession session,  
	        IoFuture future, IoSessionInitializer sessionInitializer) {   
	    try {  
	        ((AbstractIoSession) session).setAttributeMap(session.getService()  
	                .getSessionDataStructureFactory().getAttributeMap(session));  
	    } catch (IoSessionInitializationException e) {  
	        throw e;  
	    } catch (Exception e) {  
	        throw new IoSessionInitializationException(  
	                "Failed to initialize an attributeMap.", e);  
	    } 
	}
	
	/**
	 * 在 30 秒之内的每秒钟向服务器端发送一次空闲内存的数量。
	 * 分配了一个足够大的 IoBuffer 来保存一个 long 类型变量，然后将空闲内存的数量放进缓存。缓冲随即写给服务器端。
	 * @throws InterruptedException
	 */
	private static void sendData() throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			long free = Runtime.getRuntime().freeMemory();
			IoBuffer buffer = IoBuffer.allocate(8);
			buffer.putLong(free);
			buffer.flip();
			session.write(buffer);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new InterruptedException(e.getMessage());
			}
		}
	}

	static class UDPClientHandler extends IoHandlerAdapter {

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：sessionCreated");
			super.sessionCreated(session);
		}

		@Override
		public void sessionOpened(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：sessionOpened");
			super.sessionOpened(session);
		}

		@Override
		public void sessionClosed(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：sessionClosed");
			super.sessionClosed(session);
		}

		@Override
		public void sessionIdle(IoSession session, IdleStatus status)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：sessionIdle");
			super.sessionIdle(session, status);
		}

		@Override
		public void exceptionCaught(IoSession session, Throwable cause)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：sessionCaught");
			super.exceptionCaught(session, cause);
		}

		@Override
		public void messageReceived(IoSession session, Object message)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：messageReceived");
			super.messageReceived(session, message);
		}

		@Override
		public void messageSent(IoSession session, Object message)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("UDPClient：messageSent");
			super.messageSent(session, message);
		}
	}
}
