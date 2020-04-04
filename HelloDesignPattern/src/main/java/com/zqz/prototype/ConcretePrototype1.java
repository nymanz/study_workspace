package com.zqz.prototype;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:33
 * @changeRecord
 */
public class ConcretePrototype1 extends AbstractPrototype implements Cloneable{


    public ConcretePrototype1(String id){
        super(id);
    }

    @Override
    public ConcretePrototype1 clonePrototy() {
        try {
            // 浅拷贝
            return (ConcretePrototype1) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
