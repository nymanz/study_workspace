package cn.com.agree.SSLTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.example.echoserver.ssl.BogusSslContextFactory;
import org.apache.mina.filter.ssl.SslFilter;  
import org.apache.mina.filter.ssl.SslFilter.SslFilterMessage;  
 /**
  * MINA框架添加ssl加密实例——服务端适配器
  * 完成服务端业务流程
  * @author 赵乾泽
  *
  */
public class TempTLSServerHandler extends IoHandlerAdapter{
	 public void sessionCreated(IoSession session) throws Exception {  
	        System.out.println("[NIO Server]>> sessionCreated");   
	        session.setAttribute(SslFilter.USE_NOTIFICATION);  
	    }  
	  
	    public void sessionOpened(IoSession session) throws Exception {  
	        System.out.println("[NIO Server]>> sessionOpened");  
	    }  
	  
	    public void sessionClosed(IoSession session) throws Exception {  
	        System.out.println("[NIO Server]>> sessionClosed");  
	    }  
	  
	    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {  
	        System.out.println("[NIO Server]>> sessionIdle");  
	    }  
	  
	    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {  
	        System.out.println("[NIO Server]>> exceptionCaught :");  
	        cause.printStackTrace();  
	    }  
	  
	    public void messageReceived(IoSession session, Object message) throws Exception {  
	        System.out.println("[NIO Server]>> messageReceived");  
	        String msg = "";  
	        if (message instanceof SslFilterMessage) {  
	            msg = ((SslFilterMessage) message).toString();  
	        } else {  
	            msg = (String) message;  
	        }  
	        System.out.println("[NIO Server Received]>> : " + msg);  
	        if ("Hello".equalsIgnoreCase(msg)) {  
	            session.write("Hello SSL");  
	        } else if ("Client SSL Finished".equalsIgnoreCase(msg)) {  
	            session.getFilterChain().addFirst("SSL", new SslFilter(BogusSslContextFactory.getInstance(true)));  
	             //((SslFilter)session.getFilterChain().get("SSL")).startSsl(session);  
	            session.write("Server SSL Finished");  
	        } else if ("信息安全吗?".equals(msg)) {  
	            session.write("信息安全!");  
	        } else {  
	            session.write("No Support Command");  
	        }  
	    }  
	  
	    public void messageSent(IoSession session, Object message) throws Exception {  
	        System.out.println("[NIO Server]>> messageSent");  
	        System.out.println("[NIO Server messageSent]>> : " + (String) message);  
	    }  
}
