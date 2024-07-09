package org.example.model;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CityCoordinatesFetcher {
    private OkHttpClient client = new OkHttpClient();
    private String apiKey;
    private Gson gson = new Gson();

    public CityCoordinatesFetcher(String apiKey) {
        this.apiKey = apiKey;
    }

    public TupleOfDouble convertCityNameToCoOrdinates (String cityName){
        Request req = new Request.Builder().url(
                String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=5&appid=%s", cityName, this.apiKey))
                .build();

        try {
            Response res = client.newCall(req).execute();
            String jsonData = res.body().string();
            Type listType = new TypeToken<List<LocationObject>>() {}.getType();
            List<LocationObject> locations = this.gson.fromJson(jsonData, listType);

            LocationObject myObj =  locations.get(0);
            TupleOfDouble tuple = new TupleOfDouble(myObj.getLat(), myObj.getLon());
            return tuple;

        } catch (Exception e) {
            System.out.println("Request failed");
        }
        return null;
    }
}
