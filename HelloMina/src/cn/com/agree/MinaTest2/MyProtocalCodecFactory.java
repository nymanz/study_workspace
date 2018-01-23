package cn.com.agree.MinaTest2;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
/**
 * MyProtocalCodecFactory是自己创建的编解码工厂类实现了ProtocolCodecFactory接口
 * @author 赵乾泽
 *
 */
public class MyProtocalCodecFactory implements ProtocolCodecFactory{

	private final MyProtocalEncoder encoder;  
    private final MyProtocalDecoder decoder;  
      
    public MyProtocalCodecFactory(Charset charset) {  
        encoder=new MyProtocalEncoder(charset);  
        decoder=new MyProtocalDecoder(charset);  
    }  
       
    public ProtocolEncoder getEncoder(IoSession session) {  
        return encoder;  
    }  
    public ProtocolDecoder getDecoder(IoSession session) {  
        return decoder;  
    }  
    

}
