package com.zqz.chain;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 00:24
 * @changeRecord
 */
public class ConcreteHandler1 extends Handler {
    @Override
    public void HandleRequest(int request) {
        if(request >= 0 && request < 10){
            System.out.println("ConcreteHandler1处理请求：" + request);
        }else if (successor != null){
            successor.HandleRequest(request);
        }
    }
}
