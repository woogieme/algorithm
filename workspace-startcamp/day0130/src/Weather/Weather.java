package Weather;

import java.util.Date;



public class Weather {
	
	private Integer hour;
	private Double temp;
	private String wfKor;
	private String wfEN;
	private Integer reh;
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public String getWfKor() {
		return wfKor;
	}
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	public String getWfEN() {
		return wfEN;
	}
	public void setWfEN(String wfEN) {
		this.wfEN = wfEN;
	}
	public Integer getReh() {
		return reh;
	}
	public void setReh(Integer reh) {
		this.reh = reh;
	}
	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfKor=" + wfKor + ", wfEN=" + wfEN + ", reh=" + reh
				+ "]";
	}
	
}
