package com.example.ishaandhamija.volleypractice;

/**
 * Created by ishaandhamija on 18/04/17.
 */

class Main {
    Double temp;
    int humidity;

    public Main(Double temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public Double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }
}
