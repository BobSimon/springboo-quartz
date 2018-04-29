package com.example.demo.observer;

/**
 * @Author Bob Simon
 * @Description:酷热指数布告板,根据温度和湿度采用特定的公式镜像计算的
 * @Date :Created in 2018-04-21 9:20
 * @Modified By
 **/
public class HeatIndexDisplay implements Observer,DisplayElement{

    float heatIndex = 0.0f;

    private WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("酷热指数布告板，现在的酷热指数为： " + heatIndex);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        heatIndex = computeHeatIndex(temperature, humidity);
        display();
    }

    /**
     * 在布告板中自定义方法。
     */
    private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)
                + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
                + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }


}
