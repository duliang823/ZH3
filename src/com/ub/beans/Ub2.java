package com.ub.beans;

public class Ub2 {
	
	private int id;
	private String time;
	private String temp;
	private String humidity;
	private String infrared;
	private String smoke;
	private String period;//是否为周末
	
	private String d_location;	
	private String d_status  ;
	private String d_ID; 
	
	private String a_location ;
	private String a_status;
	private String a_ID ;
	
	private String f_location  ;
	private String f_status ;
	private String f_ID  ;
	
	private String c_location  ;
	private String c_status  ;
	private String c_ID ;
	
	private String tv_location  ;
	private String tv_status  ;
	private String tv_ID;
	
	
	public Ub2(int id, String time, String temp, String humidity,
			String infrared, String smoke, String period, String d_location,
			String d_status, String d_ID, String a_location, String a_status,
			String a_ID, String f_location, String f_status, String f_ID,
			String c_location, String c_status, String c_ID,
			String tv_location, String tv_status, String tv_ID) {
		super();
		this.id = id;
		this.time = time;
		this.temp = temp;
		this.humidity = humidity;
		this.infrared = infrared;
		this.smoke = smoke;
		this.period = period;
		this.d_location = d_location;
		this.d_status = d_status;
		this.d_ID = d_ID;
		this.a_location = a_location;
		this.a_status = a_status;
		this.a_ID = a_ID;
		this.f_location = f_location;
		this.f_status = f_status;
		this.f_ID = f_ID;
		this.c_location = c_location;
		this.c_status = c_status;
		this.c_ID = c_ID;
		this.tv_location = tv_location;
		this.tv_status = tv_status;
		this.tv_ID = tv_ID;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getInfrared() {
		return infrared;
	}
	public void setInfrared(String infrared) {
		this.infrared = infrared;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getD_location() {
		return d_location;
	}
	public void setD_location(String d_location) {
		this.d_location = d_location;
	}
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
	}
	public String getD_ID() {
		return d_ID;
	}
	public void setD_ID(String d_ID) {
		this.d_ID = d_ID;
	}
	public String getA_location() {
		return a_location;
	}
	public void setA_location(String a_location) {
		this.a_location = a_location;
	}
	public String getA_status() {
		return a_status;
	}
	public void setA_status(String a_status) {
		this.a_status = a_status;
	}
	public String getA_ID() {
		return a_ID;
	}
	public void setA_ID(String a_ID) {
		this.a_ID = a_ID;
	}
	public String getF_location() {
		return f_location;
	}
	public void setF_location(String f_location) {
		this.f_location = f_location;
	}
	public String getF_status() {
		return f_status;
	}
	public void setF_status(String f_status) {
		this.f_status = f_status;
	}
	public String getF_ID() {
		return f_ID;
	}
	public void setF_ID(String f_ID) {
		this.f_ID = f_ID;
	}
	public String getC_location() {
		return c_location;
	}
	public void setC_location(String c_location) {
		this.c_location = c_location;
	}
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public String getC_ID() {
		return c_ID;
	}
	public void setC_ID(String c_ID) {
		this.c_ID = c_ID;
	}
	public String getTv_location() {
		return tv_location;
	}
	public void setTv_location(String tv_location) {
		this.tv_location = tv_location;
	}
	public String getTv_status() {
		return tv_status;
	}
	public void setTv_status(String tv_status) {
		this.tv_status = tv_status;
	}
	public String getTv_ID() {
		return tv_ID;
	}
	public void setTv_ID(String tv_ID) {
		this.tv_ID = tv_ID;
	}
	
		
}
