package com.ssafy.i_xml_ui.parse.sax;

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

import com.ssafy.i_xml_ui.parse.BoxOffice;

public class BoxOfficeSaxParser extends DefaultHandler {
    private final File xml = new File("./src/com/ssafy/i_xml_ui/parse/boxoffice.xml");
    // 파싱된 내용을 저장할 List
    private List<BoxOffice> list = new ArrayList<>();
    // 현재 파싱하고 있는 대상 객체
    private BoxOffice current;
    // 방금 읽은 텍스트 내용
    private String content;

    public List<BoxOffice> getBoxOffice() {
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

    // TODO: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.
    @Override
    public void startDocument() throws SAXException {
    	System.out.println("문서 파싱 시작");
    }
    // END:
    @Override
    public void endDocument() throws SAXException {
    	System.out.println("문저 파싱 끝");
    
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	if(qName.equals("dailyBoxOffice")) {
    		current = new BoxOffice();
    	}
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	// TODO Auto-generated method stub
    	if(qName.equals("rank")){
    		this.current.setRank(Integer.parseInt(content));
    	}else if (qName.equals("movieNm")) {
    		this.current.setMovieNm(this.content);
    		
    	}else if (qName.equals("openDt")) {
    		this.current.setOpenDt(current.toDate(this.content));
    		
    	}else if (qName.equals("audiAcc")) {
    		this.current.setAudiAcc(Integer.parseInt(this.content));
    		
    	}else if (qName.endsWith("dailyBoxOffice")) {
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
