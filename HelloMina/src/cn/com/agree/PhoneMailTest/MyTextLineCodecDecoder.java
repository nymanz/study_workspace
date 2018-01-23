package cn.com.agree.PhoneMailTest;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class MyTextLineCodecDecoder implements ProtocolDecoder{

	 private Charset charset = Charset.forName("utf-8");
	    // 定义常量值，作为每个IoSession中保存解码内容的key值
	    private static String CONTEXT = MyTextLineCodecDecoder.class.getName()
	            +".context";
	 
	    public void decode(IoSession session, IoBuffer in,ProtocolDecoderOutput out)
	            throws Exception {
	        Context ctx = getContext(session);
	        decodeAuto(ctx,in, out);
	    }
	 
	    private Context getContext(IoSession session) {
	        Context ctx = (Context) session.getAttribute(CONTEXT);
	        if (ctx == null) {
	            ctx= new Context();
	            session.setAttribute(CONTEXT, ctx);
	        }
	        return ctx;
	    }
	 
	    private void decodeAuto(Context ctx, IoBuffer in,ProtocolDecoderOutput out)
	            throws CharacterCodingException {
	        boolean mark = false;
	        while (in.hasRemaining()) {
	            byte b = in.get();
	            switch (b) {
	            case '\r':
	                break;
	            case '\n':
	                mark= true;
	                break; // 跳出switch
	            default:
	                ctx.getBuf().put(b);
	            }
	 
	            if (mark) {
	                IoBuffer t_buf =ctx.getBuf();
	                t_buf.flip();
	                try {
	                    out.write(t_buf.getString(charset.newDecoder()));
	                }finally {
	                    t_buf.clear();
	                }
	            }
	        }
	    }
	 
	    public void dispose(IoSession session) throws Exception {
	        Context ctx = (Context) session.getAttribute(CONTEXT);
	        if (ctx != null) {
	            session.removeAttribute(CONTEXT);
	        }
	    }
	 
	    public void finishDecode(IoSession session, ProtocolDecoder Outputout)
	            throws Exception {
	    }
	 
	    private class Context {
	        private IoBuffer buf;
	 
	        public Context() {
	            buf = IoBuffer.allocate(100).setAutoExpand(true);
	        }
	 
	        public IoBuffer getBuf() {
	            return buf;
	        }
	    }

		@Override
		public void finishDecode(IoSession session, ProtocolDecoderOutput out)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

}
