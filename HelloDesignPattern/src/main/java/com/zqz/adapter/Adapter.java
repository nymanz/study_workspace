package com.zqz.adapter;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 20:59
 * @changeRecord
 */
public class Adapter extends Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request(){
       adaptee.specificRequest();
    }
}
