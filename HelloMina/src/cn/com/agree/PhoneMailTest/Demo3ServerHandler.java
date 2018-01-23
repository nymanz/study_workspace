package cn.com.agree.PhoneMailTest;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class Demo3ServerHandler extends IoHandlerAdapter{
	 public static Logger logger = Logger.getLogger(Demo3ServerHandler.class);
	 
	    @Override
	    public void messageReceived(IoSession session, Object message)
	            throws Exception {
/*	        String phoneMes = message.toString();
	        String[]megs=phoneMes.split(";");
	        String sendPhone = megs[0];
	        String receivePhone = megs[1];
	        String mes = megs[2];
	        logger.info("发送人手机号码：" + sendPhone);
	        logger.info("接受人手机号码：" + receivePhone);
	        logger.info("发送信息：" + mes);*/
	    	  PhoneMessageDto phoneMes =(PhoneMessageDto)message;
	          String sendPhone = phoneMes.getSendPhone();
	          String receivePhone = phoneMes.getReceivePhone();
	          String mes = phoneMes.getMessage();
	    	  
	          logger.info("发送人手机号码：" + sendPhone);
	          logger.info("接受人手机号码：" + receivePhone);
	          logger.info("发送信息：" + mes);
	        // 短信信息存入移动服务端数据库或者写入手机短信转发队列
	        // ............
	 
	        session.write("发送成功！"); //告诉手机发送信息成功啦
	    }
	 
	    @Override
	    public void messageSent(IoSession session, Object message)throws Exception {
	        session.close();
	    }
	 
	    @Override
	    public void exceptionCaught(IoSession session, Throwable cause)
	            throws Exception {
	        logger.error("服务端发送异常...", cause);
	    }
}
