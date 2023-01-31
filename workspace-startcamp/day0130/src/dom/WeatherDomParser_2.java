package dom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Weather.WeatherDto;

public class WeatherDomParser_2 {
	private List<WeatherDto> weatherList; // 핸들러가 이 리스트를 채울 예정.
	public List<WeatherDto> getWeatherList() {
		return weatherList;
	}
	
	public WeatherDomParser_2(String url) {
		weatherList = new ArrayList<>();
		
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
//			Document dom = parser.parse(new File("weather.xml"));
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			NodeList datas = root.getElementsByTagName("data"); // data 태그 리스트
			
			for(int i=0; i<datas.getLength(); i++) { // data 태그만큼 반복
				WeatherDto weather = new WeatherDto();
				NodeList children = datas.item(i).getChildNodes(); // 온도, 습도, 날씨 등등
				for(int j=0; j<children.getLength(); j++){ // 날씨 하나당 딸려있는 내부 정보 아이들
					Node child = children.item(j);
					String childName = child.getNodeName();
					if(childName.equals("hour")) {
						weather.setHour(child.getTextContent());
					}else if(childName.equals("temp")) {
						weather.setTemp(child.getTextContent());
					}else if(childName.equals("reh")) {
						weather.setReh(child.getTextContent());
					}else if(childName.equals("wfKor")) {
						weather.setWfKor(child.getTextContent());
					}else if(childName.equals("wfEng")) {
						weather.setWfEn(child.getTextContent());
					}
				} // data 하나당 딸려있는 모든 정보중 내가 관심있는 것만 weather에 담았음.
				weatherList.add(weather);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
