package cn.com.agree.Proxy;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Main {
    public static void main( String[] args ) throws Exception
    {
    	args =new String[3];
    	args[0] =args[2]="12345";
    	args[1] = "127.0.0.1";
        if ( args.length != 3 )
        {
            System.out.println( Main.class.getName()
                + " <proxy-port> <server-hostname> <server-port>" );
            return;
        }

        // Create TCP/IP acceptor.
        NioSocketAcceptor acceptor = new NioSocketAcceptor();

        // Create TCP/IP connector.
        IoConnector connector = new NioSocketConnector();

        // Set connect timeout.
        connector.setConnectTimeoutMillis( 30 * 1000L );

        ClientToProxyIoHandler handler = new ClientToProxyIoHandler( connector,
            new InetSocketAddress( args[1], Integer.parseInt( args[2] ) ) );
        // Start proxy.
        acceptor.setHandler( handler );
        acceptor.bind( new InetSocketAddress( Integer.parseInt( args[0] ) ) );

        System.out.println( "Listening on port " + Integer.parseInt( args[0] ) );
    }
}
