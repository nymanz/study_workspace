package cn.com.agree.MinaTest2;
/**
 * MyProtocalPack是自己创建的关于信息包的类
 * @author 赵乾泽
 *
 */
public class MyProtocalPack {
	private int length;  
    private byte flag;  
    private String content;  
      
    public MyProtocalPack(){  
          
    }  
      
    public MyProtocalPack(byte flag,String content){  
        this.flag=flag;  
        this.content=content;  
        int len1=content==null?0:content.getBytes().length;  
        this.length=5+len1;  
    }  
      
    public MyProtocalPack(byte[] bs){  
        if(bs!=null && bs.length>=5){  
        	 length=GFCommon.bytes2int(GFCommon.bytesCopy(bs, 0, 4));  
             flag=bs[4];  
             content=new String(GFCommon.bytesCopy(bs, 5, length-5));  
        }  
    }  
      
    public int getLength() {  
        return length;  
    }  
    public void setLength(int length) {  
        this.length = length;  
    }  
    public byte getFlag() {  
        return flag;  
    }  
    public void setFlag(byte flag) {  
        this.flag = flag;  
    }  
    public String getContent() {  
        return content;  
    }  
    public void setContent(String content) {  
        this.content = content;  
    }  
      
    public String toString(){  
        StringBuffer sb=new StringBuffer();  
        sb.append(" Len:").append(length);  
        sb.append(" flag:").append(flag);  
        sb.append(" content:").append(content);  
        return sb.toString();  
    }  
}
