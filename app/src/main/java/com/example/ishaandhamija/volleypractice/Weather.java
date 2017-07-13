package com.example.ishaandhamija.volleypractice;

/**
 * Created by ishaandhamija on 18/04/17.
 */

class Weather {
    int id;
    String main;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }
    public Weather(int id, String main) {

        this.id = id;
        this.main = main;
    }
}
