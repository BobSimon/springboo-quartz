package com.example.demo.command;

/**
 * @Author Bob Simon
 * @Description：开电视按钮
 * @Date :Created in 2018-04-20 17:28
 * @Modified By
 **/
public class OpenTvCommand implements Command {

    private Televison televison;

    /***
     * 构造方法实例化对象
     */
    public OpenTvCommand(){

        televison = new Televison();
    }

    /**
     * 开电视机
     */
    @Override
    public void excute() {
        televison.open();
    }

}
