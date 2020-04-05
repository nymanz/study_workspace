package com.zqz.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 22:17
 * @changeRecord
 */
public class ConcreteAggregate extends Aggregate {
    private List<Object> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int count(){
        return items.size();
    }

    public Object get(int index){
        return items.get(index);
    }

    public void set(int index, Object o){
        items.add(index, o);
    }
}
