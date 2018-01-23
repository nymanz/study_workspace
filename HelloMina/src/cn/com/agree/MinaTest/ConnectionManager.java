package cn.com.agree.MinaTest;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class ConnectionManager {
	private ConnectionConfig mConfig;
	private NioSocketConnector mConnection;
	private IoSession mSession;
	private InetSocketAddress mAddress;
	
	public ConnectionManager(ConnectionConfig config){
		this.mConfig = config;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mAddress = new InetSocketAddress(mConfig.getIp(),mConfig.getPort());
		mConnection = new NioSocketConnector();
		mConnection.getSessionConfig().setReadBufferSize(mConfig.getReadBufferSize());
		mConnection.getFilterChain().addLast("logging", new LoggingFilter());
		mConnection.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		mConnection.setHandler(new DefaultHander());
	}
	public boolean connect(){
		try{
			ConnectFuture future = mConnection.connect();
			future.awaitUninterruptibly();
			mSession = future.getSession();
		}catch(Exception e){
			return false;
		}
		return mSession ==null?false:true;
	}
	public void disConnection(){
		mConnection.dispose();
		mConnection = null;
		mSession=null;
		mAddress = null;
	}
		
	private static class DefaultHander extends IoHandlerAdapter{

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			super.sessionCreated(session);
		}

		@Override
		public void sessionOpened(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			super.sessionOpened(session);
			//
		}

		@Override
		public void messageReceived(IoSession session, Object message)
				throws Exception {
			// TODO Auto-generated method stub
			super.messageReceived(session, message);
		}
		
	}
}
