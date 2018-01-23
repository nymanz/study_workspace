package cn.com.agree.SSLTest;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
/**
 * MINA框架添加ssl加密实例——服务端
 * @author 赵乾泽
 *
 */
public class TempTLSServer {
	private static final int PORT = 50003;

	public static void main(String[] args) throws Exception {

		SocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.setReuseAddress(true);

		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();

		chain.addLast("codec", new ProtocolCodecFilter(
				new TextLineCodecFactory(Charset.forName("UTF-8"))));

		acceptor.setHandler(new TempTLSServerHandler());
		
		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("服务器在 [" + PORT + "] 等待连接...");
	}

}
