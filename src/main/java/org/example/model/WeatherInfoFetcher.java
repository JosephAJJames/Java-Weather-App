package org.example.model;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherInfoFetcher {
    private OkHttpClient client = new OkHttpClient();
    private String apiKey;
    private CityCoordinatesFetcher coordinatesFetcher;
    private Gson gson = new Gson();

    public WeatherInfoFetcher(String apiKey) {
        this.apiKey = apiKey;
        this.coordinatesFetcher = new CityCoordinatesFetcher(this.apiKey);
    }

    public WeatherObject makeRequest(String cityName) {
        TupleOfDouble CoOrdinates = this.coordinatesFetcher.convertCityNameToCoOrdinates(cityName);
        CoOrdinates.print();
        Request req = new Request.Builder().url(
                        String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s", CoOrdinates.getFirst(), CoOrdinates.getSecond(), this.apiKey))
                .build();
        try {
            Response res = client.newCall(req).execute();
            String jsonData = res.body().string();


            return this.gson.fromJson(jsonData, WeatherObject.class);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Heavy");
        }
        return null;
    }

}