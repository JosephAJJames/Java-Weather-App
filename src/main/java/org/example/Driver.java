package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Driver {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String APIKey = dotenv.get("API_KEY");
        WeatherInfoFetcher weatherFetcher = new WeatherInfoFetcher(APIKey);
        CityCoordinatesFetcher cityCoordsFetcher = new CityCoordinatesFetcher(APIKey);
        WeatherApp myApp = new WeatherApp(weatherFetcher, cityCoordsFetcher);
        myApp.run();
    }
}