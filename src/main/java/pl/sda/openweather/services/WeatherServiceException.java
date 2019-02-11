package pl.sda.openweather.services;

public class WeatherServiceException extends Exception {
    public WeatherServiceException() {
    }

    WeatherServiceException(String errorMessage) {
        super(errorMessage);
    }
}
