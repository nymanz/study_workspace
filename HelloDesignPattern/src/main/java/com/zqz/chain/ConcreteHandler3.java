package com.zqz.chain;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 00:29
 * @changeRecord
 */
public class ConcreteHandler3 extends Handler{
    @Override
    public void HandleRequest(int request) {
        if(request >= 20 && request < 30){
            System.out.println("ConcreteHandler3处理请求：" + request);
        }else if (successor != null){
            successor.HandleRequest(request);
        }
    }
}
