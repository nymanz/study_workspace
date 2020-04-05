package com.zqz.chain;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 00:28
 * @changeRecord
 */
public class ConcreteHandler2 extends Handler{
    @Override
    public void HandleRequest(int request) {
        if(request >= 10 && request < 20){
            System.out.println("ConcreteHandler2处理请求：" + request);
        }else if (successor != null){
            successor.HandleRequest(request);
        }
    }
}
