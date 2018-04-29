package com.example.demo.observer;

/**
 * @Author Bob Simon
 * @Description:布告板
 * @Date :Created in 2018-04-21 9:06
 * @Modified By
 **/
public class CurrentConditionsDisplay implements Observer,DisplayElement{

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

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
          System.out.println("目前状况布告板，现在温度是："+temperature+
                  "℃，"+"湿度是："+humidity+"，气压是："+pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
         this.temperature = temperature;
         this.humidity = humidity;
         this.pressure = pressure;
         display();
    }


}
