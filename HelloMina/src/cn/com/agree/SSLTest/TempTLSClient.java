package cn.com.agree.SSLTest;
import java.net.InetSocketAddress;  
import java.nio.charset.Charset;  
import java.security.GeneralSecurityException;  
  

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;  
import org.apache.mina.core.service.IoConnector;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.filter.codec.ProtocolCodecFilter;  
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;  
import org.apache.mina.transport.socket.nio.NioSocketConnector;  
/**
 * MINA框架添加ssl加密实例——客户端
 * @author 赵乾泽
 *
 */
public class TempTLSClient {
	 private static final int PORT = 50003;  
	  
	    private static final String TARGET_IP = "127.0.0.1";  
	  
	    public static void main(String[] args) throws GeneralSecurityException {  
	          
	        IoConnector connector = new NioSocketConnector();  
	          
	        connector.setHandler(new TempTLSClientHandler());  
	          
	        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));  
	          
	        ConnectFuture future = connector.connect(new InetSocketAddress(TARGET_IP, PORT));  
	          
	        future.awaitUninterruptibly();  
	          
	        IoSession session = future.getSession();  
	          
	        session.write("HELLO");  
	          
	        session.getCloseFuture().awaitUninterruptibly();  
	        connector.dispose();  
	    }  
}
