package com.zqz.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 23:55
 * @changeRecord
 */
public class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        commands.add(command);
        System.out.println("增加命令：" + command);
    }

    public void executeCommand(){
        commands.forEach(Command::execute);
    }
}
