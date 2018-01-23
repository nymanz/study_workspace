package com.herman.protocol;

import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.google.gson.Gson;
import com.herman.msg.Message;

public class MessageClientHandler extends IoHandlerAdapter {
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		//关闭会话，并强制刷新没有写完的内存
		CloseFuture future = session.close(true);
		//登录连接关闭
		future.awaitUninterruptibly();
		Gson gson=new Gson();
		Message msg=new Message();
		msg.setMsg_body("quit");
		msg.setMsg_length("msgLength");
		msg.setMsg_type("msgType");
		msg.setSign("sign");
		msg.setSign_type("signType");
		session.write(gson.toJson(msg));
	}
	public MessageClientHandler() {
		
	}

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		Gson gson=new Gson();
		Message msg=gson.fromJson(message.toString(), Message.class);
		System.out.println(msg.toString());// 显示接收到的消息
	}
}
