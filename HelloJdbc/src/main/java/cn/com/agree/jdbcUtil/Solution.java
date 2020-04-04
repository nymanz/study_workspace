package cn.com.agree.jdbcUtil;

public class Solution {
	public String replaceSpace(StringBuffer str) {
    	String str1=str.toString();
        String cc=str1.replace(" ","%20");
        return cc;
    }
    public static void main(String[] argo){
        Solution s=new Solution();
        StringBuffer str = new StringBuffer("We Are Happy.");
        String m=s.replaceSpace(str);
        System.out.println(m);
    }
}
