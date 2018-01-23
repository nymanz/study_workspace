package cn.com.agree.MinaTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionInitializationException;
import org.apache.mina.core.session.IoSessionInitializer;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
/**
 * UDP结构的服务器架构
 * @author 赵乾泽
 *
 */
public class UdpServer {
	private final static int PORT = 9234;
	
	public static void main(String[] args) throws IOException {
		// 创建UDPAcceptor,NioDatagramAccepter监听连入的客户端请求
		NioDatagramAcceptor acceptor = new NioDatagramAcceptor(null);
		// 这次不设置字符解编码器filter，消息直接用Buffer字节流传递
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.setHandler(new UDPHandler());
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		//NioDatagramAcceptor设置为null，才能重复使用端口
		acceptor.getSessionConfig().setReuseAddress(true);
		acceptor.bind(new InetSocketAddress(PORT));
	}

	static class UDPHandler extends IoHandlerAdapter {
		
		protected final void initSession(IoSession session,  
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
		
		@Override
		public void messageReceived(IoSession session, Object message)
				throws Exception {
			//int countValue = (int) session.getAttribute("count");
			//session.setAttribute("count", countValue+1);
			IoBuffer buffer = (IoBuffer) message;
			System.out.println(buffer.getLong());
			//System.out.println("count："+countValue);
			session.close(false);
		}

		@Override
		public void sessionIdle(IoSession session, IdleStatus status)
				throws Exception {
			System.out.println("IDLE " + session.getIdleCount(status));
		}

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("sessionCreated");
			//session.setAttribute("count", 1);
		}	
	}
}
