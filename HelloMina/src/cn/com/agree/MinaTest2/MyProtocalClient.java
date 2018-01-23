package cn.com.agree.MinaTest2;

import java.io.DataOutputStream;
import java.net.Socket;
/**
 * MyProtocalClient是自己创建的最简单的客户端类
 * @author 赵乾泽
 *
 */
public class MyProtocalClient {
	 public static void main(String[] args) {  
	        try {  
	            Socket socket = new Socket("127.0.0.1", 2500);  
	            DataOutputStream out =  new DataOutputStream( socket.getOutputStream() ) ;  
	            for (int i = 0; i < 1000; i++) {  
	                MyProtocalPack pack=new MyProtocalPack((byte)i,i+"测试MyProtocalaaaaaaaaaaaaaa");  
	                out.writeInt(pack.getLength());  
	                out.write(pack.getFlag());  
	                out.write(pack.getContent().getBytes());  
	                out.flush();  
	                System.out.println(i + " sended");  
	            }  
	            Thread.sleep(1000 );  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
}
