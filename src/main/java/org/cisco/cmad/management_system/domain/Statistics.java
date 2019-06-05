package org.cisco.cmad.management_system.domain;

public class Statistics {
	
	private int totalMessages;
	private int errorMessages;
	private int warnMessages;
	private int infoMessages;
	private int debugMessages;
	
	
	public int getDebugMessages() {
		return debugMessages;
	}
	public void setDebugMessages(int debugMessages) {
		this.debugMessages = debugMessages;
	}
	public int getTotalMessages() {
		return totalMessages;
	}
	public void setTotalMessages(int totalMessages) {
		this.totalMessages = totalMessages;
	}
	public int getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(int errorMessages) {
		this.errorMessages = errorMessages;
	}
	public int getWarnMessages() {
		return warnMessages;
	}
	public void setWarnMessages(int warnMessages) {
		this.warnMessages = warnMessages;
	}
	public int getInfoMessages() {
		return infoMessages;
	}
	public void setInfoMessages(int infoMessages) {
		this.infoMessages = infoMessages;
	}
	@Override
	public String toString() {
		return "Statistics [totalMessages=" + totalMessages + ", errorMessages=" + errorMessages + ", warnMessages="
				+ warnMessages + ", infoMessages=" + infoMessages + ", debugMessages=" + debugMessages + "]";
	}
	
	

}
