package cn.com.agree.MinaTest;

import java.net.InetSocketAddress;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * TCP/IP结构的客户端架构
 * 
 * @author 赵乾泽
 * 
 */
public class TcpClient {
	private static final String HOSTNAME = "127.0.0.1";
	private static final int PORT = 12345;
	private static final long CONNECT_TIMEOUT = 30 * 1000L; // 30 seconds

	public static void main(String[] args) throws Throwable {
		// 创建Connector连接器
		NioSocketConnector connector = new NioSocketConnector();
		// 设置连接超时时间
		connector.setConnectTimeoutMillis(CONNECT_TIMEOUT);
		// 过滤链中添加编解码和日志
		connector.getFilterChain().addLast("codec",
			new ProtocolCodecFilter(new TextLineCodecFactory()));
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("MyFilter", new MyIoFilter());
		//非常简单的处理Handler，向服务器发送一个数字
		connector.setHandler(new ClientSessionHandler(1));
		IoSession session = null;
		for(;;){
			try {
				// 连接远程主机，设置IP和端口
				ConnectFuture future = connector.connect(new InetSocketAddress(
						HOSTNAME, PORT));
				// 等待连接建立
				future.awaitUninterruptibly();
				// 连接建立后返回会话session
				session = future.getSession();
				session.write("客户端给服务器的消息"); 
				break;
			} catch (RuntimeIoException e) {
				System.err.println("Failed to connect.");
				e.printStackTrace();
				Thread.sleep(5000);
			}
		}
		// 等待本次连接通话结束，不可中断式的阻塞等待
		session.getCloseFuture().awaitUninterruptibly();
		// 关闭连接
		connector.dispose();
	}

	static class ClientSessionHandler extends IoHandlerAdapter {
		private final int value;

		public ClientSessionHandler(int value) {
			this.value = value;
		}

		@Override
		public void sessionOpened(IoSession session) {
			System.out.println("Client：sessionOpened：会话被打开");
			session.write(value);
		}

		@Override
		public void messageReceived(IoSession session, Object message) {
			System.out.println("Client：messageReceived：消息被接收");
			System.out.println("Client：messageReceived：" + message);
			 session.close(true); 
		}

		@Override
		public void exceptionCaught(IoSession session, Throwable cause) {
			System.out.println("Client：exceptionCaught：捕获异常");
			session.close(true);
		}

		public void sessionCreated(IoSession session) throws Exception {
			// Empty handler
			System.out.println("Client：sessionCreated：会话被创建");
		}

		public void sessionClosed(IoSession session) throws Exception {
			// Empty handler
			System.out.println("Client：sessionClosed：会话被关闭");
		}

		public void sessionIdle(IoSession session, IdleStatus status)
				throws Exception {
			// Empty handler
			System.out.println("Client：sessionIdle：会话空闲时被触发");
		}

		public void messageSent(IoSession session, Object message)
				throws Exception {
			// Empty handler
			System.out.println("Client：messageSent：" + message.toString());
			System.out.println("Client：messageSent：会话被发送");
		}
	}
}
