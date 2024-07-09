package org.example;

import org.example.controller.MainController;
import org.example.model.*;
import org.example.view.*;

import io.github.cdimascio.dotenv.Dotenv;

public class Driver {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);
        setupApp(dotenv, mainController);
    }

    public static void setupApp(Dotenv dotenv, MainController controller) {
        String APIKey = dotenv.get("API_KEY");
        System.out.println(APIKey);
        WeatherInfoFetcher weatherFetcher = new WeatherInfoFetcher(APIKey);
        CityCoordinatesFetcher cityCoordsFetcher = new CityCoordinatesFetcher(APIKey);
        KelvinToCelsius convertor = new KelvinToCelsius();
        WeatherForcaster myApp = new WeatherForcaster(weatherFetcher, cityCoordsFetcher, convertor, controller);
        myApp.run();
    }
}