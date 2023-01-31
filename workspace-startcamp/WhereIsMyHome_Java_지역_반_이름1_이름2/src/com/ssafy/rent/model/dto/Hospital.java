package com.ssafy.rent.model.dto;

public class Hospital {
	//NAME_KOR
	private String name_KOR;
	//H_KOR_DONG
	private String h_KOR_DONG;
	//poart
	private String part;
	public String getName_KOR() {
		return name_KOR;
	}
	public void setName_KOR(String name_KOR) {
		this.name_KOR = name_KOR;
	}
	public String getH_KOR_DONG() {
		return h_KOR_DONG;
	}
	public void setH_KOR_DONG(String h_KOR_DONG) {
		this.h_KOR_DONG = h_KOR_DONG;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	@Override
	public String toString() {
		return "Hospital [name_KOR=" + name_KOR + ", h_KOR_DONG=" + h_KOR_DONG + ", part=" + part + "]";
	}

	
}
