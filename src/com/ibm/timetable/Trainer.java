package com.ibm.timetable;

public class Trainer {

	private String t_name;
	private String t_sub;
	
	public Trainer(String t_name, String t_sub) {
		super();
		this.t_name = t_name;
		this.t_sub = t_sub;
	}
	
	@Override
	public String toString() {
		return "Trainer [t_name=" + t_name + ", t_sub=" + t_sub + "]";
	}

	public String getT_name() {
		return t_name;
	}
	
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	public String getT_sub() {
		return t_sub;
	}
	
	public void setT_sub(String t_sub) {
		this.t_sub = t_sub;
	}
}
