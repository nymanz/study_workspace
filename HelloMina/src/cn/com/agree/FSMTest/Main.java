package cn.com.agree.FSMTest;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.example.tapedeck.CommandDecoder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineEncoder;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.statemachine.StateMachine;
import org.apache.mina.statemachine.StateMachineFactory;
import org.apache.mina.statemachine.StateMachineProxyBuilder;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.context.IoSessionStateContextLookup;
import org.apache.mina.statemachine.context.StateContext;
import org.apache.mina.statemachine.context.StateContextFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class Main {
	 /** Choose your favorite port number. */
    private static final int PORT = 12345;
    
    private static IoHandler createIoHandler() {
        StateMachine sm = StateMachineFactory.getInstance(
                IoHandlerTransition.class).create(TapeDeckServer.EMPTY,
                new TapeDeckServer());

        return new StateMachineProxyBuilder().setStateContextLookup(
                new IoSessionStateContextLookup(new StateContextFactory() {
                    public StateContext create() {
                        return new TapeDeckServer.TapeDeckContext();
                    }
                })).create(IoHandler.class, sm);
    }
    
    public static void main(String[] args) throws Exception {
        SocketAcceptor acceptor = new NioSocketAcceptor();
        //设置的是主服务监听的端口可以重用
        acceptor.setReuseAddress(true);
        //添加过滤链
       ProtocolCodecFilter pcf = new ProtocolCodecFilter(
                new TextLineEncoder(), new CommandDecoder());
        acceptor.getFilterChain().addLast("log1", new LoggingFilter("log1"));
        acceptor.getFilterChain().addLast("codec", pcf);
        acceptor.setHandler(createIoHandler());
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("服务端开启");
    }
}
