package com.zqz.flyweight;

import java.util.Hashtable;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 01:11
 * @changeRecord
 */
public class FlyweightFactory {
    private Hashtable flyweight = new Hashtable<String, Object>();

    public FlyweightFactory(){
        flyweight.put("x", new ConcreteFlyweeight());
        flyweight.put("y", new ConcreteFlyweeight());
        flyweight.put("z", new ConcreteFlyweeight());
    }

    public Flyweight getFlyweight(String key){
        return (Flyweight) flyweight.get(key);
    }
}
