package com.zqz.facade;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 23:04
 * @changeRecord
 */
public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;

    public Facade(){
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
    }

    public void methodA(){
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }

    public void methodB(){
        one.methodOne();
        three.methodThree();
    }
}
