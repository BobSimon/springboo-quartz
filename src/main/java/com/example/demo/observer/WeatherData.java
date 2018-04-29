package com.example.demo.observer;

import java.util.ArrayList;

/**
 * @Author Bob Simon
 * @Description:实现主题接口
 * @Date :Created in 2018-04-21 8:56
 * @Modified By
 **/
public class WeatherData implements Subject{

    private ArrayList<Observer> observers;

    /**
     * 温度
     */
    private float temperature;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 气压
     */
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    /**
     * 注册成为观察者
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 移除观察者
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
       int i = observers.indexOf(o);
       if(i >= 0){
           observers.remove(o);
       }
    }

    /**
     * 这里就是将状态循环的通知给每一个观察者，因为每一个观察者都实现了update方法，
     */
    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(temperature,humidity,pressure);
        }
    }


    /**
     * 当气象站得到更新数据中，就通知观察者
     */
    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature,float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }


}
