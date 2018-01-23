package cn.com.agree.NetCatTest;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Main {
    public static void main(String[] args) throws Exception {
    	args = new String[2];
    	args[0]="127.0.0.1";
    	args[1] = "3005";
        if (args.length != 2) {
            System.out.println(Main.class.getName() + " <hostname> <port>");
            return;
        }

        // Create TCP/IP connector.
        NioSocketConnector connector = new NioSocketConnector();

        // Set connect timeout.
        connector.setConnectTimeoutMillis(30*1000L);

        // Start communication.
        connector.setHandler(new NetCatProtocolHandler());
        ConnectFuture cf = connector.connect(
                new InetSocketAddress(args[0], Integer.parseInt(args[1])));

        // Wait for the connection attempt to be finished.
        cf.awaitUninterruptibly();
        cf.getSession().getCloseFuture().awaitUninterruptibly();
        
        connector.dispose();
    }
}
