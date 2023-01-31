package com.ssafy.rent.util;

import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.rent.model.dto.Hospital;

import java.util.LinkedList;
import java.util.List;
import java.util.jar.Attributes;
public class HospitalSAXHanlder extends DefaultHandler{
    private List<Hospital> hosp;
    private Hospital hos;
    private String temp;

	public HospitalSAXHanlder() {
		hosp=new LinkedList<Hospital>();
	}
	  public void startElement(String uri, String localName, String qName, Attributes att) {
	        if (qName.equals("item")) {
	        	hos = new Hospital();
	        	hosp.add(hos);
	        }
	    }

	    public void endElement(String uri, String localName, String qName) {
	        if (qName.equals("NAME_KOR")) {            // 업종 코드
	            hos.setName_KOR((temp));
	        } else if (qName.equals("H_KOR_DONG")) {           // 업체 명
	            hos.setH_KOR_DONG(temp.trim());
	        } else if (qName.equals("PART")) {      // 점검 일자
	            hos.setPart(temp.trim());
	        }
	    }

	    public void characters(char[] ch, int start, int length) {
	        temp = new String(ch, start, length);
	    }

	    public List<Hospital> getHospital() {
	        return hosp;
	    }

	    public void setEnvs(List<Hospital> envs) {
	        this.hosp = hosp;
	    }
}
