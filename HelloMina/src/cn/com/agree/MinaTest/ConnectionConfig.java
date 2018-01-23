package cn.com.agree.MinaTest;

public class ConnectionConfig {

	private String ip;
	private int port;
	private int readBufferSize;
	private long connectionTimeout;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getReadBufferSize() {
		return readBufferSize;
	}
	public void setReadBufferSize(int readBufferSize) {
		this.readBufferSize = readBufferSize;
	}
	public long getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(long connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	
}
