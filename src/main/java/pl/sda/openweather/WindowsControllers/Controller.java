package pl.sda.openweather.WindowsControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pl.sda.openweather.model.Weather;
import pl.sda.openweather.services.WeatherService;
import pl.sda.openweather.services.WeatherServiceException;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label temperature_lab;
    @FXML
    private TextField cityText;
    @FXML
    private ImageView weatherIcon;

    @FXML

    public void btnPress(ActionEvent actionEvent) {
        WeatherService weatherService = new WeatherService();

        try {
            Weather weather = weatherService.getWeatherForCity(cityText.getText());
            temperature_lab.setTextFill(Color.web("000000"));
            temperature_lab.setText("Temperature in "
                    + weather.getLocation().getCountry()
                    + "\n city " + cityText.getText() + " : "
                    + weather.getCurrent().getTemp_c());
            weatherIcon.setImage(new Image("http:" + weather.getCurrent().getCondition().getIcon()));
        } catch (WeatherServiceException e) {
            temperature_lab.setTextFill(Color.web("FF0000"));
            temperature_lab.setText("Nie można pobrać informacji o pogodzie!!");
            weatherIcon.setImage(null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        temperature_lab.setAlignment(Pos.CENTER);
        temperature_lab.setFont(Font.font("Arial Bold", FontWeight.BOLD, 15));

    }
}
