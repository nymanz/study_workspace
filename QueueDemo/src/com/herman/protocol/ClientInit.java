package com.herman.protocol;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.google.gson.Gson;
import com.herman.msg.Message;
import com.herman.util.SocketUtil;

public class ClientInit {
	public static void main(String[] args) {
		// 创建客户端连接器
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		// 设置编码过滤器
//		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
		connector.setConnectTimeoutMillis(30000L);
		// 设置事件处理器
		connector.setHandler(new MessageClientHandler());
		// 建立连接
		ConnectFuture cf = connector.connect(new InetSocketAddress(SocketUtil.LOCAL_IP,SocketUtil.PORT));
		// 等待连接创建完成
		cf.awaitUninterruptibly();
		// 发送消息
		Gson gson=new Gson();
		Message msg=new Message();
		msg.setMsg_body("hello");
		msg.setMsg_length("msgLength");
		msg.setMsg_type("msgType");
		msg.setSign("sign");
		msg.setSign_type("signType");
		cf.getSession().write(gson.toJson(msg));
		// 发送消息
		msg.setMsg_body("quit");
		cf.getSession().write(gson.toJson(msg));
		// 等待连接断开
		cf.getSession().getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
