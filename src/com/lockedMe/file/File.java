package com.lockedMe.file;
//import java.time.LocalDateTime;

public class File {
	
	private String name;
	private String type;
	private String time_of_creation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime_of_creation() {
		return time_of_creation;
	}
	public void setTime_of_creation(String time_of_creation) {
		this.time_of_creation = time_of_creation;
	}
	
	@Override
	public String toString() {
		return "File [name=" + name + ", type=" + type + ", time_of_creation=" + time_of_creation + "]";
	}
	

}
