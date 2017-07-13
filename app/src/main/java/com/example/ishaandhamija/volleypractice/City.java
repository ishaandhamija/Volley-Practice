package com.example.ishaandhamija.volleypractice;

import java.util.ArrayList;

/**
 * Created by ishaandhamija on 18/04/17.
 */

public class City {

    Main main;

    public Main getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    ArrayList<Weather> weather;

    public City(Main main, ArrayList<Weather> weather) {
        this.main = main;
        this.weather = weather;
    }
}
