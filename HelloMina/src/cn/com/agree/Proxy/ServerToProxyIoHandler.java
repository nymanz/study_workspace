package cn.com.agree.Proxy;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 处理服务器的代理的代理连接部分。
 * @author 赵乾泽
 *
 */
public class ServerToProxyIoHandler extends AbstractProxyIoHandler{

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：sessionCreated");
		super.sessionCreated(session);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：sessionClosed");
		super.sessionClosed(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：sessionReceived");
		super.messageReceived(session, message);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：sessionOpened");
		super.sessionOpened(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：sessionIdle");
		super.sessionIdle(session, status);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：exceptionCaught");
		super.exceptionCaught(session, cause);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server：messageSent");
		super.messageSent(session, message);
	}

}
