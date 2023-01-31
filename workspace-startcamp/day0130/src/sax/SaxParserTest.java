package sax;

import java.util.List;

import Weather.Weather;
import dom.WeatherDomParser;

public class SaxParserTest {
	public static void main(String[] args) {
        WeatherSaxParser parser = new WeatherSaxParser();
        
        List<Weather> list = parser.getWeather();

        for (Weather info : list) {
            System.out.println(info);
        }
	}
}
