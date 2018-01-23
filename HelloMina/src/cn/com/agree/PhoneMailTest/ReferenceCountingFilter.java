package cn.com.agree.PhoneMailTest;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;

public class ReferenceCountingFilter implements IoFilter {
	  private final IoFilter filter;
	  
	    private int count = 0;
	 
	    public ReferenceCountingFilter(IoFilter filter) {
	       this.filter = filter;
	    }
	 
	    public void init() throws Exception {
	       //no-op, will init on-demand in pre-add if count == 0
	    }
	    public void destroy() throws Exception {
	          }

		@Override
		public void onPreAdd(IoFilterChain parent, String name,
				NextFilter nextFilter) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPostAdd(IoFilterChain parent, String name,
				NextFilter nextFilter) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPreRemove(IoFilterChain parent, String name,
				NextFilter nextFilter) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPostRemove(IoFilterChain parent, String name,
				NextFilter nextFilter) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sessionCreated(NextFilter nextFilter, IoSession session)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sessionOpened(NextFilter nextFilter, IoSession session)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sessionClosed(NextFilter nextFilter, IoSession session)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sessionIdle(NextFilter nextFilter, IoSession session,
				IdleStatus status) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void exceptionCaught(NextFilter nextFilter, IoSession session,
				Throwable cause) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputClosed(NextFilter nextFilter, IoSession session)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void messageReceived(NextFilter nextFilter, IoSession session,
				Object message) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void messageSent(NextFilter nextFilter, IoSession session,
				WriteRequest writeRequest) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void filterClose(NextFilter nextFilter, IoSession session)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void filterWrite(NextFilter nextFilter, IoSession session,
				WriteRequest writeRequest) throws Exception {
			// TODO Auto-generated method stub
			
		}
}
