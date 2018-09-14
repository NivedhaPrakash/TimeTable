package com.ibm.timetable;

public class TimeTable {

	private double time;
	private String mon;
	private String tue;
	private String wed;
	private String thrus;
	private String fri;
	
	public TimeTable(double time) {
		this.time=time;
	}
	
	public TimeTable(double time, String mon, String tue, String wed,String thrus,String fri) {
		this.time = time;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thrus=thrus;
		this.fri=fri;
	}
	
	public String getThrus() {
		return thrus;
	}

	public void setThrus(String thrus) {
		this.thrus = thrus;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getTue() {
		return tue;
	}
	public void setTue(String tue) {
		this.tue = tue;
	}
	public String getWed() {
		return wed;
	}
	public void setWed(String wed) {
		this.wed = wed;
	}
	
}
