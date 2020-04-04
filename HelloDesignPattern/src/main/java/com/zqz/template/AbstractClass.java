package com.zqz.template;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 22:36
 * @changeRecord
 */
public abstract class AbstractClass {
    public abstract void Operation1();
    public abstract void Operation2();

    public void TemplateMethod(){
        Operation1();
        Operation2();
    }
}
