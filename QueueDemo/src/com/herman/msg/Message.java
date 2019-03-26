package com.herman.msg;

public class Message {
	private String sign_type;//签名(MD5、RSA、DSA)
	private String sign;//签名字符串
	private String msg_length;//报文长度
	private String msg_type;//报文类型
	private String msg_body;//报文内容
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String signType) {
		sign_type = signType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getMsg_length() {
		return msg_length;
	}
	public void setMsg_length(String msgLength) {
		msg_length = msgLength;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msgType) {
		msg_type = msgType;
	}
	public String getMsg_body() {
		return msg_body;
	}
	public void setMsg_body(String msgBody) {
		msg_body = msgBody;
	}
	public Message() {
		super();
	}
	public Message(String signType, String sign, String msgLength,
				   String msgType, String msgBody) {
		super();
		sign_type = signType;
		this.sign = sign;
		msg_length = msgLength;
		msg_type = msgType;
		msg_body = msgBody;
	}
	@Override
	public String toString() {
		return "Message [msg_body=" + msg_body + ", msg_length=" + msg_length
				+ ", msg_type=" + msg_type + ", sign=" + sign + ", sign_type="
				+ sign_type + "]";
	}
}
