package org.example.model;

import org.example.controller.MainController;
import org.jxmapviewer.viewer.DefaultWaypoint;

import java.util.Scanner;

public class WeatherForcaster implements Observer{
    private WeatherInfoFetcher fetcher;
    private CityCoordinatesFetcher cityFetcher;
    private KelvinToCelsius tempConvertor;
    private MainController controller;



    private int round;
    public WeatherForcaster(WeatherInfoFetcher myFetcher, CityCoordinatesFetcher myCityFetcher, KelvinToCelsius convertor, MainController controller) {
        this.fetcher = myFetcher;
        this.cityFetcher = myCityFetcher;
        this.tempConvertor = convertor;
        this.controller = controller;
        this.controller.addObservor(this);
    }


    public void doTheWeather(String city) {
        WeatherObject myWeather = this.fetcher.makeRequest(city);
    }

    @Override
    public void notifyObj(DefaultWaypoint waypoint) {

    }
}
