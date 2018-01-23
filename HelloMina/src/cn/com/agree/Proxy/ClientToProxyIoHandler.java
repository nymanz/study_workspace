package cn.com.agree.Proxy;

import java.net.SocketAddress;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ClientToProxyIoHandler extends AbstractProxyIoHandler{
    private final ServerToProxyIoHandler connectorHandler = new ServerToProxyIoHandler();

    private final IoConnector connector;

    private final SocketAddress remoteAddress;

    public ClientToProxyIoHandler(IoConnector connector,
            SocketAddress remoteAddress) {
        this.connector = connector;
        this.remoteAddress = remoteAddress;
        connector.setHandler(connectorHandler);
        
    }
    public void messageSent(IoSession session, Object message) throws Exception {
        // Empty handler
    	session.write("客户端的消息");
    }
    @Override
    public void sessionOpened(final IoSession session) throws Exception {
    	System.out.println("Client：sessionOpened");
        connector.connect(remoteAddress).addListener(new IoFutureListener<ConnectFuture>() {
            public void operationComplete(ConnectFuture future) {
                try {
                    future.getSession().setAttribute(OTHER_IO_SESSION, session);
                    session.setAttribute(OTHER_IO_SESSION, future.getSession());
                    IoSession session2 = future.getSession();
                    session2.resumeRead();
                    session2.resumeWrite();
                } catch (RuntimeIoException e) {
                    // Connect failed
                    session.closeNow();
                } finally {
                    session.resumeRead();
                    session.resumeWrite();
                }
            }
        });
    }
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：sessionCreated");
		super.sessionCreated(session);
	}
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：sessionClosed");
		super.sessionClosed(session);
	}
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：messageReceived");
		super.messageReceived(session, message);
	}
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：sessionIdle");
		super.sessionIdle(session, status);
	}
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client：exceptionCaught");
		super.exceptionCaught(session, cause);
	}
    
}
