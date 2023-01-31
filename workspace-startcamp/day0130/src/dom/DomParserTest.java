package dom;

import java.util.List;

import Weather.Weather;

public class DomParserTest {
	public static void main(String[] args) {
        WeatherDomParser parser = new WeatherDomParser();
        List<Weather> list = parser.getWeather();

        for (Weather info : list) {
            System.out.println(info);
        }
	}
}
