package com.ssafy.simple.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BoardDTO {
	private int bno;
	private String bwriter;
	private String btitle;
	private String bcontent;
	private String bwriteDate;
	private List<FileDTO> files = new ArrayList<FileDTO>();
	
	public BoardDTO() {}

	public List<FileDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileDTO> files) {
		this.files = files;
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

	public String getBwriteDate() {
		return bwriteDate;
	}

	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bwriteDate=" + bwriteDate + "]";
	}
}
