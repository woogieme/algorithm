package sax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Weather.WeatherDto;

public class WeatherSaxParser_1 {
	private List<WeatherDto> weatherList; //핸들러가 이 리스트를 채울 예정, 그냥 시작하자마자 만들거임 [선택지2]

	public WeatherSaxParser_1() {
		
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new File("./src/weather.xml"), handler);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<WeatherDto> getWeatherList() {
		return weatherList;
	}
	public class SAXHandler extends DefaultHandler{
		WeatherDto weather;
		StringBuilder sb; //태그를 읽으면서 내려가다가 내가 원하는 글자들을 가져다가 이어 붙이는 작업시 용이함.
		
		//태그와 태그 사이의 글자를 하나씩 읽으면서 실행됨
		@Override  //ch에서 start부터  length까지 append
		public void characters(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
			sb.append(ch,start,length);
		}
		@Override //어떤 시작 태그를 만났을때실해행됨
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			// TODO Auto-generated method stub
			super.startElement(uri, localName, qName, attributes);
			if(qName.equals("data")){ //오 data 태그다 ! 날씨 시작 !! 
					weather = new WeatherDto();
			}
			sb = new StringBuilder(); //자 일단 시작태그 만났다하면 무조건 새로운 sb만들어놓자
		} 
		
		//어떤 태그가 끝났을때 실행됨
		//data 를 만났을때 weather를 만들고 set해서 값넣고  data로 마지막으로 끝난다면 리스트에 담는다
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			if(weather != null) {
				if(qName.equals("hour")) {
					weather.setHour(sb.toString().trim());
				}else if(qName.equals("temp")) {
					weather.setTemp(sb.toString().trim());
				}else if(qName.equals("wfKor")) {
					weather.setWfKor(sb.toString().trim());
				}else if(qName.equals("WfEN")) {
					weather.setWfEn(sb.toString().trim());
				}else if(qName.equals("reh")) {
					weather.setReh(sb.toString().trim());
				}if(qName.equals("data")) {
					weatherList.add(weather);
					
				}
			}
		}
		
		//전체 문서 읽기 시작
		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
			weatherList = new ArrayList<>(); //시작을할때 어레이를 만들거야 ! [선택지 1]
		}
		
	}
}
