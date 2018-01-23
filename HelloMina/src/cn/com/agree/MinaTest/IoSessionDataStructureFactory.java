package cn.com.agree.MinaTest;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionAttributeMap;
/**
 * 想要在会话中定义其他类型的容器，用来保存会话中的常量或需多次使用的变量、参数
 * 容器工厂
 * @author 赵乾泽
 *
 */
public interface IoSessionDataStructureFactory {
	 /** 
     * Returns an {@link IoSessionAttributeMap} which is going to be associated 
     * with the specified <tt>session</tt>.  Please note that the returned 
     * implementation must be thread-safe. 
     */  
     IoSessionAttributeMap getAttributeMap(IoSession session) throws Exception;  
}
