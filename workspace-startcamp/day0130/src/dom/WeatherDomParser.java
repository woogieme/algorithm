package dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Weather.Weather;

public class WeatherDomParser {
	private final File xml = new File("./src/weather.xml");
	private List<Weather> list =new ArrayList<>();
	
	
	public List<Weather> getWeather(){
		 
         try {
    	 	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xml);
			Element root = doc.getDocumentElement();
			parse(root);
		} catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
		return list;
	}


	private void parse(Element root) {
		// TODO Auto-generated method stub
		NodeList weatherlist = root.getElementsByTagName("data");
		for (int i = 0; i < weatherlist.getLength(); i++) {
			Node child = weatherlist.item(i);
			list.add(getWeather(child));
			
		}
		
	}


	private static Weather getWeather(Node node) {
		// TODO Auto-generated method stub
		Weather weatheOffice = new Weather();
		
		NodeList childs =node.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if(child.getNodeName().equals("hour")) {
				weatheOffice.setHour((Integer.parseInt(child.getTextContent())));
			}else if(child.getNodeName().equals("temp")) {
				weatheOffice.setTemp((Double.parseDouble((child.getTextContent()))));
			}else if(child.getNodeName().equals("wfKor")) {
				weatheOffice.setWfKor((child.getTextContent()));
			}else if(child.getNodeName().equals("wfEn")) {
				weatheOffice.setWfEN((child.getTextContent()));
			}else if(child.getNodeName().equals("reh")) {
				weatheOffice.setReh((Integer.parseInt(child.getTextContent())));
			}
		}
		return weatheOffice;
	}
}
