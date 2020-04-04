package com.zqz.prototype;

import com.zqz.factory.AbstractProduct;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:28
 * @changeRecord
 */
public abstract class AbstractPrototype {

    private String id;

    public AbstractPrototype(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public abstract AbstractPrototype clonePrototy();
}
