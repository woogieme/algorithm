package sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import Weather.Weather;


public class WeatherSaxParser extends DefaultHandler{
	private final File xml = new File("./src/weather.xml");
	private List<Weather> list =new ArrayList<>();
    private Weather current;
    // 방금 읽은 텍스트 내용
    private String content;
	public List<Weather> getWeather() {
        // TODO: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
    	try {
        	SAXParserFactory factory = SAXParserFactory.newInstance(); // 공장을 하나만듬
        	SAXParser parser=factory.newSAXParser();

			parser.parse(xml, this);
			
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //직급이 들어가는거임 , defaulyhandler가 있기떄문에 this
        // END:
        return list;
    }
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("문서 파싱 시작");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("문저 파싱 끝");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equals("data")) {
			current =new Weather();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equals("hour")) {
			this.current.setHour((Integer.parseInt(this.content)));
		}else if(qName.equals("temp")) {
			this.current.setTemp((Double.parseDouble((this.content))));
		}else if(qName.equals("wfKor")) {
			this.current.setWfKor(this.content);
		}else if(qName.equals("wfEn")) {
			this.current.setWfEN(this.content);
		}else if(qName.equals("reh")) {
			this.current.setReh((Integer.parseInt(this.content)));
		}else if (qName.endsWith("data")) {
    		this.list.add(this.current);
    		this.current=null;
    	}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		this.content = new String(ch, start, length);
	}
}
