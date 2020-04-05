package com.zqz.iterator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 22:26
 * @changeRecord
 */
public class Test {

    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.set(0,"大鸟");
        aggregate.set(1,"小菜");
        aggregate.set(2,"行李");
        aggregate.set(3,"老外");

        Iterator i = new ConcreteIterator(aggregate);
        Object first = i.first();
        while (!i.isDone()){
            System.out.println(i.currentItem() + "请买车票");
            i.next();
        }

    }
}
