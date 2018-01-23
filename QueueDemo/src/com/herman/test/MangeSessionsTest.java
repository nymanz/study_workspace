package com.herman.test;

import java.util.Iterator;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.herman.protocol.ServerInit;

public class MangeSessionsTest {
	public static void main(String[] args) {
		ServerInit si=new ServerInit();
		si.inti();
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(si.getAcceptor()==null){
			//再上面服务监听启动之后的十秒时间内启动客户端通讯
			System.out.println("我日，它怎么为空呢");
			return;
		}
		Map<Long, IoSession> map=si.getAcceptor().getManagedSessions();
		Iterator<Long> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			IoSession session = (IoSession) map.get(key);
			System.err.println("key:"+key.toString()+"          session.getId:"+session.getId());
		}
	}
}
