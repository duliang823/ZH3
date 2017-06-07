package com.ub.beans;

public class Ub1 {
	
	private int id;
	private String time;
	private String temp;
	private String humidity;
	private String infrared;
	private String smoke;
	private String period;//是否为周末
	private String d_status  ;
	private String a_status ;
	private String f_status ;
	private String c_status   ;
	private String tv_status   ;

	public Ub1(int id, String time, String temp, String humidity,
			String infrared, String smoke, String period, String d_status,
			String a_status, String f_status, String c_status, String tv_status) {
		super();
		this.id = id;
		this.time = time;
		this.temp = temp;
		this.humidity = humidity;
		this.infrared = infrared;
		this.smoke = smoke;
		this.period = period;
		this.d_status = d_status;
		this.a_status = a_status;
		this.f_status = f_status;
		this.c_status = c_status;
		this.tv_status = tv_status;
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
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
	}
	public String getA_status() {
		return a_status;
	}
	public void setA_status(String a_status) {
		this.a_status = a_status;
	}
	public String getF_status() {
		return f_status;
	}
	public void setF_status(String f_status) {
		this.f_status = f_status;
	}
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public String getTv_status() {
		return tv_status;
	}
	public void setTv_status(String tv_status) {
		this.tv_status = tv_status;
	}

		
}
