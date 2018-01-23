package cn.com.agree.PhoneMailTest;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TestServer03 {
	 private static Logger logger = Logger.getLogger(TestServer03.class);
	    private static int PORT = 3005;
	    public static void main(String[] args) {
	        IoAcceptor acceptor = null;
	        try {
	            // 创建一个非阻塞的server端的Socket
	            acceptor = new NioSocketAcceptor();
	            // 设置过滤器
/*	            acceptor.getFilterChain().addLast(
	                    "codec",
	                    new ProtocolCodecFilter(new TextLineCodecFactory(Charset
	                            .forName("UTF-8"),
	                            LineDelimiter.WINDOWS.getValue(),
	                            LineDelimiter.WINDOWS.getValue())));*/
	            acceptor.getFilterChain().addLast(
	                    "codec",
	                    new ProtocolCodecFilter(
	                            new ObjectSerializationCodecFactory()));
/*	            acceptor.getFilterChain().addLast("Filter", new ReferenceCountingFilter());*/
	            // 获得IoSessionConfig对象
	            IoSessionConfig cfg = acceptor.getSessionConfig();
	            // 读写通道10秒内无操作进入空闲状态
	            cfg.setIdleTime(IdleStatus.BOTH_IDLE, 100);
	 
	            // 绑定逻辑处理器
	            acceptor.setHandler(new Demo3ServerHandler());
	            // 绑定端口
	            acceptor.bind(new InetSocketAddress(PORT));
	            logger.info("服务端启动成功...     端口号为：" + PORT);
	        }catch (Exception e) {
	            logger.error("服务端启动异常....", e);
	            e.printStackTrace();
	        }
	    }
}
