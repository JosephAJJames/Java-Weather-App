package org.example.model;

import org.example.controller.MainController;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.example.view.WeatherInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class WeatherForcaster implements Observer{
    private WeatherInfoFetcher fetcher;
    private CityCoordinatesFetcher cityFetcher;
    private KelvinToCelsius tempConvertor;
    private MainController controller;
    private JPanel mapPanel = new JPanel();



    private int round;
    public WeatherForcaster(WeatherInfoFetcher myFetcher, CityCoordinatesFetcher myCityFetcher, KelvinToCelsius convertor, MainController controller) {
        this.fetcher = myFetcher;
        this.cityFetcher = myCityFetcher;
        this.tempConvertor = convertor;
        this.controller = controller;
        this.controller.addObservor(this);
    }


    public String[] doTheWeather(GeoPosition pos) {
        WeatherObject myWeath = this.fetcher.makeRequest(pos);
        int temp = (int) myWeath.getMain().getTemp();
        WeatherObject.Weather[] arr = myWeath.getWeather();
        String desc = arr[0].getDescription();
        return new String[]{Integer.toString(temp), desc};
    }


    public void makeNewPanel(GeoPosition pos, String desc, int temp) {
        this.controller.getMainView().showWeatherPanel(pos, desc, temp);
    }


    @Override
    public void notifyObj(DefaultWaypoint waypoint) {
        String[] displayInfo = this.doTheWeather(waypoint.getPosition());

        this.makeNewPanel(waypoint.getPosition(), displayInfo[1], Integer.parseInt(displayInfo[0]));
    }
}
