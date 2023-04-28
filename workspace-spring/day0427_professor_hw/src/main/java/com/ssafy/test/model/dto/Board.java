package com.ssafy.test.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Board {
	
	private int bno;
	private String bwriter;
	private String btitle;
	private String bcontent;
	private String bwriteDate;
	@Autowired
	private List<FileDTO> listFile = new ArrayList<>();
	
	
	public Board(int bno, String bwriter, String btitle, String bcontent, String bwriteDate, List<FileDTO> listFile) {
		super();
		this.bno = bno;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.listFile = listFile;
	}
	public String getBwriteDate() {
		return bwriteDate;
	}
	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}
	public List<FileDTO> getListFile() {
		return listFile;
	}
	public void setListFile(List<FileDTO> listFile) {
		this.listFile = listFile;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwrite_date() {
		return bwriteDate;
	}
	public void setBwrite_date(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}
	public Board() {
		
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bwrite_date=" + bwriteDate + "]";
	}
	
	
    
}
