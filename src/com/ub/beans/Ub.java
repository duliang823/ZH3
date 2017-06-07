package com.ub.beans;

public class Ub {
	
	private int id;
	private String time;
	private String temp;
	private String humidity;
	private String infrared;
	private String smoke;
	private String period;//是否为周末
	private String location ;
	private String device;
	private String DI;
	private String status  ;
	
/*	
	public Ub(int id, String time, String temp, String humidity,
			String infrared, String smoke, String period, String location,
			String device, String dI, String status) {
		super();
		this.id = id;
		this.time = time;
		this.temp = temp;
		this.humidity = humidity;
		this.infrared = infrared;
		this.smoke = smoke;
		this.period = period;
		this.location = location;
		this.device = device;
		DI = dI;
		this.status = status;
	}
*/
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the temp
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/**
	 * @return the humidity
	 */
	public String getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the infrared
	 */
	public String getInfrared() {
		return infrared;
	}

	/**
	 * @param infrared the infrared to set
	 */
	public void setInfrared(String infrared) {
		this.infrared = infrared;
	}

	/**
	 * @return the smoke
	 */
	public String getSmoke() {
		return smoke;
	}

	/**
	 * @param smoke the smoke to set
	 */
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * @return the dI
	 */
	public String getDI() {
		return DI;
	}

	/**
	 * @param dI the dI to set
	 */
	public void setDI(String dI) {
		DI = dI;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	

}
