package com.example.demo.observer;

/**
 * @Author Bob Simon
 * @Description天气预报布告板
 * @Date :Created in 2018-04-21 9:11
 * @Modified By
 **/
public class ForecastDisplay implements Observer,DisplayElement{

    /**
     * 当前的气压
     */
    private float currentPressure = 29.92f;

    /**
     * 最后的气压
     */
    private float lastPressure;

    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        if (currentPressure > lastPressure) {
            System.out.println("天气预报布告板，现在是：气压升高，天气转好！");
        } else if (currentPressure == lastPressure) {
            System.out.println("天气预报布告板，现在是：气压不变，天气维持！");
        } else if (currentPressure < lastPressure) {
            System.out.println("天气预报布告板，现在是：气压降低，天气变坏！");
        }

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        /**
         * 将当前的气压赋给最后的气压
         */
        lastPressure = currentPressure;

        /**
         * 将更新的气压赋给当前气压
         */
        currentPressure = pressure;
        display();
    }


}
