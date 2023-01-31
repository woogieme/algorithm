package sax;

import java.util.List;

import Weather.Weather;
import Weather.WeatherDto;

public class SaxParsetTest2 {
	public static void main(String[] args) {
		
	
    WeatherSaxParser_1 parser = new WeatherSaxParser_1();
    
    List<WeatherDto> list = parser.getWeatherList();

    for (WeatherDto info : list) {
        System.out.println(info);
    }
	}
}
