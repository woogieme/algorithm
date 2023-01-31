package dom;

import java.util.List;

import Weather.Weather;
import Weather.WeatherDto;

public class DomParserTest2 {
	public static void main(String[] args) {
        WeatherDomParser_1 parser = new WeatherDomParser_1();
        List<WeatherDto> list = parser.getWeatherList();

        for (WeatherDto info : list) {
            System.out.println(info);
        }
	}
}
