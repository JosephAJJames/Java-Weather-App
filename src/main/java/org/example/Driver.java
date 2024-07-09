package org.example;

import org.example.model.*;

import io.github.cdimascio.dotenv.Dotenv;

public class Driver {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String APIKey = dotenv.get("API_KEY");
        System.out.println(APIKey);
        WeatherInfoFetcher weatherFetcher = new WeatherInfoFetcher(APIKey);
        CityCoordinatesFetcher cityCoordsFetcher = new CityCoordinatesFetcher(APIKey);
        KelvinToCelsius convertor = new KelvinToCelsius();
        WeatherApp myApp = new WeatherApp(weatherFetcher, cityCoordsFetcher, convertor);
        myApp.run();
    }
}