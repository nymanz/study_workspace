package cn.com.agree.VMTest;

import org.apache.mina.example.tennis.TennisPlayer;

public class TennisBall {
    private final boolean ping;

    private final int ttl;

    /**
     * Creates a new ball with the specified TTL (Time To Live) value.
     * 
     * @param ttl The time to live
     */
    public TennisBall(int ttl) {
        this(ttl, true);
    }

    /**
     * Creates a new ball with the specified TTL value and PING/PONG state.
     */
    private TennisBall(int ttl, boolean ping) {
        this.ttl = ttl;
        this.ping = ping;
    }

    /**
     * @return the TTL value of this ball.
     */
    public int getTTL() {
        return ttl;
    }

    /**
     * @return the ball after {@link TennisPlayer}'s stroke.
     * The returned ball has decreased TTL value and switched PING/PONG state.
     */
    public TennisBall stroke() {
        return new TennisBall(ttl - 1, !ping);
    }

    /**
     * @return string representation of this message (<code>[PING|PONG]
     * (TTL)</code>).
     */
    @Override
    public String toString() {
        if (ping) {
            return "PING (" + ttl + ")";
        } else {
            return "PONG (" + ttl + ")";
        }
    }
}
