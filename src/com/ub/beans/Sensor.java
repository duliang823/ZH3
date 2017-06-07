package com.ub.beans;

public class Sensor {
	
	private int id;
	private String time;
	private String temp;
	private String humidity;
	private String infrared;
	private String smoke;
	
	/*public Sensor(){
		
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
	
}
