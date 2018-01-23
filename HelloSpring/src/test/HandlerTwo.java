package cn.com.agree.SpringTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class HandlerTwo extends IoHandlerAdapter {
	 @Override
	    public void messageReceived(IoSession session, Object message)
	            throws Exception {
	        // TODO Auto-generated method stub
	    //    super.messageReceived(session, message);
	        System.out.println("received message :"+message);
	    }

	    @Override
	    public void sessionClosed(IoSession session) throws Exception {
	        // TODO Auto-generated method stub
	        super.sessionClosed(session);
	    }

	    @Override
	    public void sessionIdle(IoSession session, IdleStatus status)
	            throws Exception {
	        // TODO Auto-generated method stub
	        super.sessionIdle(session, status);
	    }
}
