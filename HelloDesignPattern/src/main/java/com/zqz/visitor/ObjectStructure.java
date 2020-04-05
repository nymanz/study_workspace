package com.zqz.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
*
 * @created 2020-04-06 02:15
 * @changeRecord
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void attach(Element element){
        elements.add(element);
    }

    public void detach(Element element){
        elements.remove(element);
    }

    public void accept(Visitor visitor){
        elements.forEach(element -> element.accept(visitor));
    }
}
