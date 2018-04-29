package com.example.demo.observer;

/**
 * @Author Bob Simon
 * @Description：主题
 * @Date :Created in 2018-04-20 18:42
 * @Modified By
 **/
public interface Subject {

    /**
     * 观察者注册
     */
    public void registerObserver(Observer o);

    /**
     *  移除观察者
     */
    public void removeObserver(Observer o);

    /**
     * 当主题状态该变时，这个方法就会被调用，以通知所有的观察者
     */
    public void notifyObserver();

}
