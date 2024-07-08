package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

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

    public void makeRequest(String cityName) {
        TupleOfDouble CoOrdinates = this.coordinatesFetcher.convertCityNameToCoOrdinates(cityName);
        CoOrdinates.print();
        Request req = new Request.Builder().url(
                        String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s", CoOrdinates.getFirst(), CoOrdinates.getSecond(), this.apiKey))
                .build();
        try {
            Response res = client.newCall(req).execute();
            String jsonData = res.body().string();


            System.out.println(this.gson.fromJson(jsonData, WeatherObject.class));

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Heavy");
        }
    }

}