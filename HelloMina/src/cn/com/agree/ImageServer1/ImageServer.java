package cn.com.agree.ImageServer1;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.example.imagine.step1.codec.ImageCodecFactory;
import org.apache.mina.example.imagine.step1.server.ImageServerIoHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class ImageServer {
    public static final int PORT = 33789;

    public static void main(String[] args) throws IOException {
        
        // Create a class that handles sessions, incoming and outgoing data
        ImageServerIoHandler handler = new ImageServerIoHandler();
        
        // This socket acceptor will handle incoming connections
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        
        // add an IoFilter .  This class is responsible for converting the incoming and 
        // outgoing raw data to ImageRequest and ImageResponse objects
        acceptor.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new ImageCodecFactory(false)));
        
        // set this NioSocketAcceptor's handler to the ImageServerHandler
        acceptor.setHandler(handler);
        
        // Bind to the specified address.  This kicks off the listening for 
        // incoming connections
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("Step 1 server is listenig at port " + PORT);
    }
}
