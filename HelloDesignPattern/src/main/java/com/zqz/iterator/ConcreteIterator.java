package com.zqz.iterator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 22:16
 * @changeRecord
 */
public class ConcreteIterator extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate){
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.get(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        current++;
        if(current < aggregate.count()){
            ret = aggregate.get(current);
        }
        return ret;
    }

    @Override
    public Object currentItem() {
        return aggregate.get(current);
    }

    @Override
    public boolean isDone() {
        return current >= aggregate.count();
    }
}
