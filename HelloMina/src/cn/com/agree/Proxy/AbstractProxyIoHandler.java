package cn.com.agree.Proxy;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractProxyIoHandler extends IoHandlerAdapter {
    private static final Charset CHARSET = Charset.forName("UTF-8");
    public static final String OTHER_IO_SESSION = AbstractProxyIoHandler.class.getName()+".OtherIoSession";

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractProxyIoHandler.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("sessionCreated");
    	session.suspendRead();
        session.suspendWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        if (session.getAttribute( OTHER_IO_SESSION ) != null) {
            IoSession sess = (IoSession) session.getAttribute(OTHER_IO_SESSION);
            sess.setAttribute(OTHER_IO_SESSION, null);
            sess.closeOnFlush();
            session.setAttribute(OTHER_IO_SESSION, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        IoBuffer rb = (IoBuffer) message;
        IoBuffer wb = IoBuffer.allocate(rb.remaining());
        rb.mark();
        wb.put(rb);
        wb.flip();
        ((IoSession) session.getAttribute(OTHER_IO_SESSION)).write(wb);
        rb.reset();
        LOGGER.info(rb.getString(CHARSET.newDecoder()));
    }

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionOpened");
		super.sessionOpened(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionIdle");
		super.sessionIdle(session, status);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("exceptionCaught");
		super.exceptionCaught(session, cause);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("messageSent");
		super.messageSent(session, message);
	}
    
}
