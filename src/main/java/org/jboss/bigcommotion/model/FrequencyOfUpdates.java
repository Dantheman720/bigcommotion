package org.jboss.bigcommotion.model;

public enum FrequencyOfUpdates {
	
	UNKNOWN("Unknown"), LOW("Low"), MED("Medium"), HIGH("High");
	
	private final String type;
	
	private FrequencyOfUpdates(String type) {
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
