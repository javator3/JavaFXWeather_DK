package pl.sda.openweather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openweather.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherService extends IOException {
    public Weather getWeatherForCity(String city) throws WeatherServiceException {
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather;
        try {
            String urlNormalized = "http://api.apixu.com/v1/current.json?key=c58fd33d79104bb385190240191002&q="
                    + URLEncoder.encode(city, "UTF-8");
            URL finalUrl = new URL(urlNormalized);
            weather = objectMapper.readValue(finalUrl, Weather.class);
        } catch (IOException e) {
            throw new WeatherServiceException("Cannot take Weather Details!");
        }
        return weather;
    }
}

