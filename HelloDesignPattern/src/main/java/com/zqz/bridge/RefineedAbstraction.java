package com.zqz.bridge;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 23:28
 * @changeRecord
 */
public class RefineedAbstraction extends Abstraction {

    @Override
    public void operation(){
        implementor.operation();
    }
}
