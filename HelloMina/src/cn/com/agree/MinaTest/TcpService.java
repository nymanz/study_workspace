package cn.com.agree.MinaTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * TCP/IP结构的服务器架构
 * 
 * @author 赵乾泽
 * 
 */
public class TcpService {
	private static final int PORT = 12345;

	public static void main(String[] args) throws IOException {
		// 首先，我们为服务端创建IoAcceptor，NioSocketAcceptor是基于NIO的服务端监听器
		IoAcceptor acceptor = new NioSocketAcceptor();
		// 接着，如结构图示，在Acceptor和IoHandler之间将设置一系列的Fliter
		// 包括记录过滤器和编解码过滤器。其中TextLineCodecFactory是mina自带的文本解编码器
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset
						.forName("UTF-8"))));
		acceptor.getFilterChain().addLast("MyFilter", new MyIoFilter());
		// 配置事务处理Handler，将请求转由TimeServerHandler处理。
		acceptor.setHandler(new TimeServerHandler());
		// 配置Buffer的缓冲区大小
		acceptor.getSessionConfig().setReadBufferSize(2048);
		// 设置等待时间，每隔IdleTime将调用一次handler.sessionIdle()方法
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		// 绑定端口
		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("服务器开启");
	}

	static class TimeServerHandler extends IoHandlerAdapter {

		public void exceptionCaught(IoSession session, Throwable cause)
				throws Exception {
			System.out.println("Service：exception");
			cause.printStackTrace();
		}

		/**
		 * messageReceived方法会从客户端接收数据并将当前时间回写给客户端
		 */
		public void messageReceived(IoSession session, Object message)
				throws Exception {
			int countValue = (int) session.getAttribute("count");
			session.setAttribute("count", countValue + 1);
			System.out.println(countValue);
			String str = message.toString();
			if (str.trim().equalsIgnoreCase("quit")) {
				session.close(false);
				return;
			}
			Date date = new Date();
			session.write(date.toString());
			System.out.println("Service：messageReceived：" + message);
		}

		public void sessionIdle(IoSession session, IdleStatus status)
				throws Exception {
			System.out.println("Service：sessionIdle：IDLE "
					+ session.getIdleCount(status));
		}

		public void sessionCreated(IoSession session) throws Exception {
			// Empty handler
			System.out.println("Service：sessionCreated：服务器会话被创建");
			session.setAttribute("count", 1);
		}

		public void sessionOpened(IoSession session) throws Exception {
			// Empty handler
			System.out.println("Service：sessionOpened：服务器会话被打开");
		}

		public void sessionClosed(IoSession session) throws Exception {
			// Empty handler
			System.out.println("Service：sessionClosed：服务器会话被关闭");
		}

		public void messageSent(IoSession session, Object message)
				throws Exception {
			// Empty handler
			System.out.println("Service：messageSent：" + message);
			System.out.println("Service：messageSent：服务器消息被发送");
		}
	}
}
