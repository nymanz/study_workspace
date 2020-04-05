package com.zqz.composite;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 21:43
 * @changeRecord
 */
public class Leaf extends Component {

    public Leaf(String name){
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove to a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println("depth: " + depth + " " + name);
    }
}
