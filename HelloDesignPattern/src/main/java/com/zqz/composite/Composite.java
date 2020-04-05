package com.zqz.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 21:46
 * @changeRecord
 */
public class Composite extends Component {

    private List<Component> children = new ArrayList<>();

    public Composite(String name){
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        System.out.println("depth: " + depth + " " + name);
        children.forEach(component -> component.display(depth + 2));
    }
}
