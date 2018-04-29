package com.example.demo.command;

/**
 * @Author Bob Simon
 * @Description：关闭电视机
 * @Date :Created in 2018-04-20 17:28
 * @Modified By
 **/
public class CloseTvCommand implements Command {

    private Televison televison;

    /***
     * 构造方法实例化对象
     */
    public CloseTvCommand(){

        televison = new Televison();
    }

    /**
     * 关电视机
     */
    @Override
    public void excute() {
        televison.close();
    }

}
