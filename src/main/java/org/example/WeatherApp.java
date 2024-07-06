package org.example;

import java.util.Scanner;

public class WeatherApp {
    private WeatherInfoFetcher fetcher;
    private CityCoordinatesFetcher cityFetcher;

    private int round;
    public WeatherApp(WeatherInfoFetcher myFetcher, CityCoordinatesFetcher myCityFetcher) {
        this.fetcher = myFetcher;
        this.cityFetcher = myCityFetcher
    }

    public void run() {
        while (1 == 1) {
            this.setRound(1);
            this.printFirstRoundOptions();
            this.processFirstRound();
            this.setRound(2);
            this.printSecondRoundOption();
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

    }

    public void processFirstRound() {
        Scanner myScanner = new Scanner(System.in);
        int result = myScanner.nextInt();
        this.processFirstRoundOptions(result);
    }

    public void processSecondRound() {
        Scanner myScanner = new Scanner(System.in);
        String result = myScanner.next();
    }
}
