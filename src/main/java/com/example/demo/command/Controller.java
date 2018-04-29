package com.example.demo.command;

/**
 * @Author Bob Simon
 * @Description：遥控器类
 * @Date :Created in 2018-04-20 17:19
 * @Modified By
 **/
public class Controller {

    /**
     * 打开电视机指令
     */
    private Command openTvCommand;

    /**
     * 关闭电视机指令
     */
    private Command closeTvCommand;

    /**
     * 改变频道指令
     */
    private Command changeTvCommand;

    /**
     * 构造方法
     * @param openTvCommand
     * @param closeTvCommand
     * @param changeTvCommand
     */
    public Controller(Command openTvCommand, Command closeTvCommand, Command changeTvCommand) {
        this.openTvCommand = openTvCommand;
        this.closeTvCommand = closeTvCommand;
        this.changeTvCommand = changeTvCommand;
    }

    /**
     * 开电视机指令
     */
    public void open(){
        openTvCommand.excute();
    }

    /**
     * 关闭电视机指令
     */
    public void close(){
        closeTvCommand.excute();
    }

    /**
     * 改变频道指令
     */
    public void change(){
        changeTvCommand.excute();
    }


}
