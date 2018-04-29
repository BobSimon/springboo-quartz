package com.example.demo.command;

/**
 * @Author Bob Simon
 * @Description：用户端
 * @Date :Created in 2018-04-20 17:40
 * @Modified By
 **/
public class Client {

    public static void main(String[] args){

        Command openCommand,closeCommand,changeCommand;
        openCommand = new OpenTvCommand();
        closeCommand = new  CloseTvCommand();
        changeCommand = new  ChangeTvCommand();

        Controller controller = new Controller(openCommand,closeCommand,changeCommand);

        controller.open();

        controller.close();

        controller.change();

    }


}
