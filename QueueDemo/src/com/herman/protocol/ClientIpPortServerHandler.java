package com.herman.protocol;

import java.util.Date;

import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.google.gson.Gson;
import com.herman.msg.Message;

public class ClientIpPortServerHandler extends IoHandlerAdapter {
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		//super.exceptionCaught(session, cause);
		//关闭会话，并强制刷新没有写完的内存
		CloseFuture future = session.close(true);
		//登录连接关闭
		future.awaitUninterruptibly();
	}
	@Override
	public void sessionCreated(IoSession session) {
		//显示客户端的ip和端口
		System.out.println("客户端的ip和端口:"+session.getRemoteAddress().toString());
	}
	@Override
	public void messageReceived(IoSession session, Object message ) throws Exception{
		test1(session,message);
	}
	void test1(IoSession session, Object message){
		Gson gson=new Gson();
		Message msg=gson.fromJson(message.toString(), Message.class);
		System.out.println(msg.toString());
		if(msg.getMsg_body().trim().equalsIgnoreCase("quit")&&!session.isClosing()) {
			//关闭会话，并强制刷新没有写完的内存
			CloseFuture future = session.close(true);
			//登录连接关闭
			future.awaitUninterruptibly();
			return;
		}
		Date date = new Date();
		msg.setMsg_body(date.toString());
		session.write(gson.toJson(msg));//返回当前时间的字符串
	}
	void test0(IoSession session, Object message){
		String str = message.toString();
		System.out.println(str);
		System.out.println(str.trim().equalsIgnoreCase("quit"));
		System.out.println(!session.isClosing());
		if(str.trim().equalsIgnoreCase("quit")&&!session.isClosing()) {
			//关闭会话，并强制刷新没有写完的内存
			CloseFuture future = session.close(true);
			//登录连接关闭
			future.awaitUninterruptibly();
			return;
		}
		Date date = new Date();
		session.write( "返回当前时间的字符串"+date.toString() );//返回当前时间的字符串
		System.out.println("Message written...");
	}
}
