package org.example.model;

import org.example.controller.MainController;

import java.util.Scanner;

public class WeatherForcaster {
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
    }

    public void run() {
        while (1 == 1) {
            this.setRound(1);
            this.printFirstRoundOptions();
            this.processFirstRound();
            this.setRound(2);
            this.printSecondRoundOption();
            this.processSecondRound();
        }
    }

    public void printSecondRoundOption() {
        System.out.println("Input your city:");
    }

    public void printFirstRoundOptions() {
        System.out.println("1. Input 1 to select city");
        System.out.println("2. Input 2 to exit");
    }

    public void setRound(int num) {
        this.round = num;
    }

    public int getRound() {
        return this.round;
    }

    public void processFirstRoundOptions(int option) {
        if (option == 1) {
            System.out.println("City Selected");
        } else { //must be 2
            System.out.println("Exiting.....");
            System.exit(1);
        }
    }

    public void processSecondRoundOptions(String city) {
        WeatherObject myWeather = this.fetcher.makeRequest(city);
        this.printTheWeather(myWeather);
    }

    public void processFirstRound() {
        Scanner myScanner = new Scanner(System.in);
        int result = myScanner.nextInt();
        this.processFirstRoundOptions(result);
    }

    public void processSecondRound() {
        Scanner myScanner = new Scanner(System.in);
        String result = myScanner.next();
        this.processSecondRoundOptions(result);
    }

    public void printTheWeather(WeatherObject weather) {
        weather.printWeatherArray();
        System.out.println("");
        int celsius = this.tempConvertor.convert(weather.getMain().getTemp());
        System.out.println(celsius);
    }

}
