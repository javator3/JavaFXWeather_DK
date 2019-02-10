package pl.sda.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Label temperature_lab;
    @FXML
    private TextField  cityText;
    @FXML
    private ImageView iconView;
    @FXML

    public void btnPress(ActionEvent actionEvent)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String city = cityText.getText();

        Weather weather = null;
        try {
            URL urltmp = new URL( "http://api.apixu.com/v1/current.json?key=c58fd33d79104bb385190240191002&q="+city);
            objectMapper.
            weather = objectMapper.readValue(urltmp, Weather.class);

            temperature_lab.setTextFill(Color.web("000000"));
            temperature_lab.setFont(Font.font("Arial Bold", FontWeight.BOLD,15));
            temperature_lab.setText("Temperature in city "+ city + " : " + weather.getCurrent().getTemp_c());
            iconView.setImage(new Image("http:"+weather.getCurrent().getCondition().getIcon()));
        } catch (IOException e) {
            temperature_lab.setTextFill(Color.web("FF0000"));
            temperature_lab.setAlignment(Pos.BASELINE_CENTER);
            temperature_lab.setFont(Font.font("Arial Bold", FontWeight.BOLD,15));
            temperature_lab.setText("Nie można pobrać informacji o pogodzie!!");
            iconView.setImage(null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
