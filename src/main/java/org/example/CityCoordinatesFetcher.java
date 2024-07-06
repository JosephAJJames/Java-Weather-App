package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CityCoordinatesFetcher {
    private OkHttpClient client = new OkHttpClient();
    private String apiKey;

    public CityCoordinatesFetcher(String apiKey) {
        this.apiKey = apiKey;
    }
}
