package com.zqz.composite;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 21:49
 * @changeRecord
 */
public class Test {

    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite comp = new Composite("composite X");
        comp.add(new Leaf("Leaf xA"));
        comp.add(new Leaf("Leaf xB"));

        root.add(comp);

        Composite comp2 = new Composite("composite XY");
        comp2.add(new Leaf("Leaf xYA"));
        comp2.add(new Leaf("Leaf xYB"));

        comp.add(comp2);

        root.add(new Leaf("Leaf C"));

        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        root.display(1);

    }
}
