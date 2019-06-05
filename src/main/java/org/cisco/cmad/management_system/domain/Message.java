package org.cisco.cmad.management_system.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue
	private int id;
	private long datetime;
	private String description;
	private String severity;
	private String deviceName;
	private String deviceLocation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getDatetime() {
		return datetime;
	}
	public void setDatetime(long datetime) {
		this.datetime = datetime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceLocation() {
		return deviceLocation;
	}
	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", datetime=" + datetime + ", description=" + description + ", severity="
				+ severity + ", deviceName=" + deviceName + ", deviceLocation=" + deviceLocation + "]";
	}
	
	
	

}
