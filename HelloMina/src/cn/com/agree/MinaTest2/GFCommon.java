package cn.com.agree.MinaTest2;

import java.nio.ByteBuffer;
/**
 * GFCommon对服务端与客户端之间传递的信息进行的处理
 * @author 赵乾泽
 *
 */
public class GFCommon {
	/**
	 * 
	 * @param bytes
	 * @return	缓冲区当前位置上的int值。
	 */
	public static int bytes2int(byte[] bytes) {  
		//分配新的缓冲区，参数为缓冲区容量
	    ByteBuffer buffer = ByteBuffer.allocate(4);  
	    //此方法将给定源字节数组的全部内容传递到这个缓冲区。
	    //这种形式的方法的调用（a）行为与调用的方式完全相同。
	    buffer.put(bytes);  
	    //在一系列的通道读或放操作之后，调用这个方法来准备一系列的通道写或相对获取操作。
	    buffer.flip();// need flip  
	    //The int value at the buffer's current position
	    return buffer.getInt();  
	}  
	/**
	 * 
	 * @param x
	 * @return The byte array that backs this buffer
	 */
	public static byte[] int2bytes(int x) {  
	    ByteBuffer buffer = ByteBuffer.allocate(4);  
	    //以当前字节顺序将包含给定长值的八个字节写入当前位置的缓冲区，然后将位置递增八。
	    buffer.putLong(x);  
	    return buffer.array();  
	}  
	/**
	 * 
	 * @param src
	 * @param begin
	 * @param count
	 * @return 该字节数组中从开始位置起，一共count个字节
	 */
	public static byte[] bytesCopy(byte[] src, int begin, int count) {  
	    byte[] bs = new byte[count];  
	    for (int i = begin; i < begin + count; i++)  
	        bs[i - begin] = src[i];  
	    return bs;  
	}  
}
