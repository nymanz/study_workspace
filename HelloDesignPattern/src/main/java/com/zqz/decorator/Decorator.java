package com.zqz.decorator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 18716022536
 * @created 2020-04-04 18:14
 * @changeRecord
 */
public abstract class Decorator extends Component {

    protected Component component;


    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        if(component!= null){
            component.Operation();
        }
    }
}
