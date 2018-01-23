package cn.com.agree.MinaTest2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
/**
 *服务端主线程
 * @author 赵乾泽
 *
 */
public class MyProtocalServer {
	//端口号
	private static final int PORT = 2500;
	//日志
	static Logger logger = Logger.getLogger(MyProtocalServer.class);

	public static void main(String[] args) throws IOException {
		//读配置文件
		PropertyConfigurator.configure("conf//log4j.properties");
		//配置IoAccept
		IoAcceptor acceptor = new NioSocketAcceptor();
		//向过滤链添加日志（可自己写）
		Log4jFilter lf = new Log4jFilter(logger);
		acceptor.getFilterChain().addLast("logger", lf);
		//向过滤链添加编解码（可自己写）
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new MyProtocalCodecFactory(Charset
						.forName("UTF-8"))));
		//设置读取容量
		acceptor.getSessionConfig().setReadBufferSize(1024);
		//设置无接受和输出的挂起时间
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		//设置控制器（可自己写）
		acceptor.setHandler(new MyHandler());
		//捆绑socket到本地地址，并且开始接受客户端连接
		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("start server ...");
	}
}
/**
 * MyHandler是自己创建的服务端的控制器实现了IoHandlerAdapter接口
 * @author 赵乾泽
 *
 */
class MyHandler extends IoHandlerAdapter {
	//为控制器添加日志
	static Logger logger = Logger.getLogger(MyHandler.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println("Service：exceptionCaught");
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		System.out.println("Service：messageReceived："+message);
		MyProtocalPack pack = (MyProtocalPack) message;
		logger.debug("Rec:" + pack);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		System.out.println("Service：sessionIdle");
		logger.debug("IDLE " + session.getIdleCount(status));
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service：sessionCreated");
		super.sessionCreated(session);
		
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service：sessionOpened");
		super.sessionOpened(session);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service：sessionClosed");
		super.sessionClosed(session);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service：messageSent");
		super.messageSent(session, message);
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service：inputClosed");
		super.inputClosed(session);
	}
	
}
