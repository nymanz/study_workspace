package com.zqz.singleton;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 23:01
 * @changeRecord
 */
public class Esingleton {
    private static Esingleton instance = new Esingleton();

    private Esingleton(){}

    public static Esingleton getInstance(){
        return instance;
    }
}
