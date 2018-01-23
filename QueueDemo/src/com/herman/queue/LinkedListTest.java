package com.herman.queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
/**
 * @see 队列的初步认识
 * @author Herman.Xiong
 * @date 2014年2月27日 08:58:15
 * @version V1.0
 * @since jdk 1.6
 */
public class LinkedListTest {
	public static void main(String[] args) {  
        LinkedListTest t=new LinkedListTest();
        t.test0();
        t.test1();
    }  
	
	void test0(){
		/**
		 * @see LinkedList先进先出队列
		 */
		Queue<String> queue = new LinkedList<String>();  
        queue.offer("Hello");  
        queue.offer("World!");  
        queue.offer("你好！");  
        System.out.println(queue.size());  
        String str;  
        while((str=queue.poll())!=null){  
            System.out.print(str);  
        }  
        System.out.println();  
        System.out.println(queue.size());  
	}
	
	@SuppressWarnings("unchecked")
	void test1(){
		LinkedList  list = new LinkedList();  
        
        list.add("one");  
        list.add("two");  
        list.add("three");        
        System.out.println("<--list中共有 ：" + list.size() + "个元素-->");  
        System.out.println("<--list中的内容 ：" + list + "-->");  
          
        String first = (String) list.getFirst();  
        String last = (String) list.getLast();  
        System.out.println("<--list中第一个元素为 ：" + first + "-->");  
        System.out.println("<--list中最后一个元素为 ：" + last + "-->");  
          
        list.addFirst("Begin");  
        list.addLast("End");  
        System.out.println("<--list中共有 ：" + list.size() + "个元素-->");  
        System.out.println("<--list中的内容 ：" + list + "-->");  
          
        System.out.println("<--使用ListIterator接口操作list-->");  
        ListIterator lit = list.listIterator();  
        System.out.println("<--下一个索引是"+ lit.nextIndex()+ "-->");  
        lit.next();  
        lit.add("zero"); 
        //先前的
        lit.previous();  
        System.out.println("<--上一个索引是"+ lit.previousIndex()+ "-->");        
        lit.previous();  
        System.out.println("<--上一个索引是"+ lit.previousIndex()+ "-->");  
        lit.set("Start");  
        System.out.println("<--list中的内容 ：" + list + "-->");  
          
        System.out.println("<--删除list中的zero-->");  
        lit.next();  
        lit.next();  
        lit.remove();  
        System.out.println("<--list中的内容 ：" + list + "-->");  
          
          
        System.out.println("<--删除list中的第一个和最后一个元素-->");  
        list.removeFirst();  
        list.removeLast();  
          
        System.out.println("<--list中共有 ：" + list.size() + "个元素-->");  
        System.out.println("<--list中的内容 ：" + list + "-->");  
	}
}
