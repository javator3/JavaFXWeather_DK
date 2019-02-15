package pl.sda.openweather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openweather.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

public class  WeatherService {
    private String urlBase;

    public WeatherService(String url, String key) {
        this.urlBase = url + "?key=" + key + "&q=";
    }

    public Weather getWeatherForCity(String city) throws WeatherServiceException {
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather;
        try {
            String urlNormalized = urlBase + URLEncoder.encode(city, "UTF-8");
            URL finalUrl = new URL(urlNormalized);
            weather = objectMapper.readValue(finalUrl, Weather.class);
        } catch (IOException e) {
            throw new WeatherServiceException("Cannot take Weather Details!");
        }
        return weather;
    }
}

