package cn.com.agree.VMTest;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.tennis.TennisBall;
import org.apache.mina.example.tennis.TennisPlayer;
import org.apache.mina.transport.vmpipe.VmPipeAcceptor;
import org.apache.mina.transport.vmpipe.VmPipeAddress;
import org.apache.mina.transport.vmpipe.VmPipeConnector;

public class Main {
    public static void main(String[] args) throws Exception {
        IoAcceptor acceptor = new VmPipeAcceptor();
        VmPipeAddress address = new VmPipeAddress(8080);

        // Set up server
        acceptor.setHandler(new TennisPlayer());
        acceptor.bind(address);

        // Connect to the server.
        VmPipeConnector connector = new VmPipeConnector();
        connector.setHandler(new TennisPlayer());
        ConnectFuture future = connector.connect(address);
        future.awaitUninterruptibly();
        IoSession session = future.getSession();

        // Send the first ping message
        session.write(new TennisBall(10));

        // Wait until the match ends.
        session.getCloseFuture().awaitUninterruptibly();

        acceptor.unbind();
    }
}
