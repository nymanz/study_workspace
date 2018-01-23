package cn.com.agree.PhoneMailTest;

import java.io.Serializable;

public class PhoneMessageDto implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sendPhone; // 发送人手机号
	 
	    private String receivePhone; // 接收人手机号
	 
	    private String message; // 短信信息
	 
	    public String getSendPhone() {
	        return sendPhone;
	    }
	 
	    public void setSendPhone(String sendPhone) {
	        this.sendPhone = sendPhone;
	    }
	 
	    public String getReceivePhone() {
	        return receivePhone;
	    }
	 
	    public void setReceivePhone(String receivePhone) {
	        this.receivePhone = receivePhone;
	    }
	 
	    public String getMessage() {
	        return message;
	    }
	    public void setMessage(String message) {
	        this.message = message;
	    }
}
