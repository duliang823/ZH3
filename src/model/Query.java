package model;

public class Query {
	int id;
	String name;
	String value;
	String time;
	
	
	public Query(int id,String name, String value, String time) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.time = time;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
