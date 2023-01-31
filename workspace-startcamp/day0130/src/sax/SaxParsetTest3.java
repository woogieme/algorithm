package sax;

import java.util.List;

import Weather.Weather;
import Weather.WeatherDto;

public class SaxParsetTest3 {
	private static String[] item = { "서울", "광주", "구미", "대전", "부울경" };
    private static String[] dong = { "1168064000", "2915573000", "4719060000", "3020052600", "2635061000" };
	public static void main(String[] args) {
	String url ="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+dong[3];
	
    WeatherSaxParser_2 parser = new WeatherSaxParser_2(url);
    
    List<WeatherDto> list = parser.getWeatherList();

    for (WeatherDto info : list) {
        System.out.println(info);
    }
	}
}
