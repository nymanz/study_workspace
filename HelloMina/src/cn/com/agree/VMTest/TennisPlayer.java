package cn.com.agree.VMTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.tennis.TennisBall;

public class TennisPlayer extends IoHandlerAdapter{
	 private static int nextId = 0;

	    /** Player ID **/
	    private final int id = nextId++;

	    @Override
	    public void sessionOpened(IoSession session) {
	        System.out.println("Player-" + id + ": READY");
	    }

	    @Override
	    public void sessionClosed(IoSession session) {
	        System.out.println("Player-" + id + ": QUIT");
	    }

	    @Override
	    public void messageReceived(IoSession session, Object message) {
	        System.out.println("Player-" + id + ": RCVD " + message);

	        TennisBall ball = (TennisBall) message;

	        // Stroke: TTL decreases and PING/PONG state changes.
	        ball = ball.stroke();

	        if (ball.getTTL() > 0) {
	            // If the ball is still alive, pass it back to peer.
	            session.write(ball);
	        } else {
	            // If the ball is dead, this player loses.
	            System.out.println("Player-" + id + ": LOSE");
	            session.closeNow();
	        }
	    }

	    @Override
	    public void messageSent(IoSession session, Object message) {
	        System.out.println("Player-" + id + ": SENT " + message);
	    }

	    @Override
	    public void exceptionCaught(IoSession session, Throwable cause) {
	        cause.printStackTrace();
	        session.closeNow();
	    }
}
