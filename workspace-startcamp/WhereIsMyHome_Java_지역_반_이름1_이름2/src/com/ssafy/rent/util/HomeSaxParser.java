package com.ssafy.rent.util;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomeInfo;
import com.ssafy.rent.model.dto.Hospital;

/**
 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용해서 식품 정보를 load하는 SAX Parser 프로 그램  
 *
 */
public class HomeSaxParser {
	private Map<String, List<HomeDeal>> deals;
	private Map<String, HomeInfo> homeInfo;
	private Map<String, Hospital> hospital;
	public List<String> getHospital() {
		return hospital;
	}

	public void setHospital(Map<String, Hospital> hospital) {
		this.hospital = hospital;
	}

	private int size;
	/**
	 * 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 
	 * 현재 버전에서는 0번부터 순차 부여한다. 
	 */
	public static int no;
 	public HomeSaxParser() {
		loadData();
	}
 	
 	/**
 	 * HomeSAXHandler를 이용 파싱한 아파트 거래 내역을 추출한다. 
 	 */
	private void loadData() {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		String aptInfoFilePath = "res/AptInfo.xml";
		String aptDealFilePath = "res/AptDealHistory.xml";
		String aptRentFilePath = "res/AptRentHistory.xml";
		String homeDealFilePath = "res/HomeDealHistory.xml";
		String homeRentFilePath = "res/HomeRentHistory.xml";
		String hospitalFilePathURL ="res/hospital.xml";
		
		
		try{
			SAXParser parser = factory.newSAXParser();
			HomeSAXHandler handler = new HomeSAXHandler();
			parser.parse(aptInfoFilePath, handler);
			homeInfo = handler.getHomeInfo();
			//System.out.println(homeInfo.toString());
			
			HospitalSAXHanlder hosSAXHandler = new HospitalSAXHanlder();
			parser.parse(hospitalFilePathURL, hosSAXHandler);
			hospital = hosSAXHandler.getEnvs();
			
			APTDealSAXHandler  aptDealHandler = new APTDealSAXHandler();
			parser.parse(aptDealFilePath, aptDealHandler);
			List<HomeDeal> aptDeals = aptDealHandler.getHomes();
			
			HomeDealSAXHandler  homeDealHandler = new HomeDealSAXHandler();
			parser.parse(homeDealFilePath, homeDealHandler);
			List<HomeDeal> homeDeals = homeDealHandler.getHomes();
			
			APTRentSAXHandler  aptRentHandler = new APTRentSAXHandler();
			parser.parse(aptRentFilePath, aptRentHandler);
			List<HomeDeal> aptRents = aptRentHandler.getHomes();
			
			HomeRentSAXHandler  homeRentHandler = new HomeRentSAXHandler();
			parser.parse(homeRentFilePath, homeRentHandler);
			List<HomeDeal> homeRents = homeRentHandler.getHomes();
			
			size = aptDeals.size() + homeDeals.size() + aptRents.size() + homeRents.size();
			
			deals = new HashMap<String, List<HomeDeal>>();
			
			deals.put(HomeDeal.APT_DEAL, aptDeals);
			deals.put(HomeDeal.APT_RENT, aptRents);
			deals.put(HomeDeal.HOME_DEAL, homeDeals);
			deals.put(HomeDeal.HOME_RENT, homeRents);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Map<String, List<HomeDeal>> getDeals() {
		return deals;
	}
	public void setDeals(HashMap<String, List<HomeDeal>> deals) {
		this.deals = deals;
	}
	public Map<String, HomeInfo> getHomeInfo() {
		return homeInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setHomeInfo(Map<String, HomeInfo> homeInfo) {
		this.homeInfo = homeInfo;
	}

	public static void main(String[] args) {
		new HomeSaxParser();
	}
}
