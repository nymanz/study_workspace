package cn.com.agree.SSLTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.echoserver.ssl.BogusSslContextFactory;
import org.apache.mina.example.tcp.perf.TcpSslServer;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TCPSslServer extends IoHandlerAdapter{
    /** The listening port (check that it's not already in use) */
    public static final int PORT = 18567;

    /** The number of message to receive */
    public static final int MAX_RECEIVED = 100000;

    /** The starting point, set when we receive the first message */
    private static long t0;

    /** A counter incremented for every recieved message */
    private AtomicInteger nbReceived = new AtomicInteger(0);

    /**
     * {@inheritDoc}
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
        session.closeNow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        int nb = nbReceived.incrementAndGet();

        if (nb == 1) {
            t0 = System.currentTimeMillis();
        }

        if (nb == MAX_RECEIVED) {
            long t1 = System.currentTimeMillis();
            System.out.println("-------------> end " + (t1 - t0));
        }

        if (nb % 10000 == 0) {
            System.out.println("Received " + nb + " messages");
        }

        // If we want to test the write operation, uncomment this line
        session.write(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("Session closed...");

        // Reinitialize the counter and expose the number of received messages
        System.out.println("Nb message received : " + nbReceived.get());
        nbReceived.set(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("Session created...");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("Session idle...");
    }

    /**
     * {@inheritDoc}
     * @param session the current seession
     * @throws Exception If something went wrong
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("Session Opened...");
    }

    /**
     * Create the TCP server
     * 
     * @throws IOException If something went wrong
     * @throws GeneralSecurityException  If something went wrong 
     */
    public TCPSslServer() throws IOException, GeneralSecurityException {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        
        // Inject the SSL filter
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        SslFilter sslFilter = new SslFilter(BogusSslContextFactory
            .getInstance(true));
        chain.addLast("sslFilter", sslFilter);

        acceptor.setHandler(this);

        // The logger, if needed. Commented atm
        //DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //chain.addLast("logger", new LoggingFilter());

        acceptor.bind(new InetSocketAddress(PORT));

        System.out.println("Server started...");
    }

    /**
     * The entry point.
     * 
     * @param args The arguments
     * @throws IOException If something went wrong
     */
    public static void main(String[] args) throws Exception {
        new TcpSslServer();
    }
}
