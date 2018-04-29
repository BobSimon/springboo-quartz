package com.example.demo.observer;

/**
 * @Author Bob Simon
 * @Description:天气布告板
 * @Date :Created in 2018-04-21 9:17
 * @Modified By
 **/
public class StatisticsDisplay implements Observer,DisplayElement{

    /**
     * 最高温度
     */
    private float maxTemp = 0.0f;

    /**
     * 最低温度
     */
    private float minTemp = 200;

    /**
     * 总的温度
     */
    private float tempSum= 0.0f;

    /**
     * 总的次数
     */
    private int numReadings;

    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("天气统计布告板，平均温度是： " + (tempSum / numReadings)
                + "，最高温度是：" + maxTemp + "，最低温度是：" + minTemp);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;
        if (temperature > maxTemp) {
            maxTemp = temperature;
        }

        if (temperature < minTemp) {
            minTemp = temperature;
        }

        display();
    }



}
