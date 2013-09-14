package org.jboss.bigcommotion.model;

public enum ConferenceType {

	INDUSTRY("Industry"), HOSTED("Hosted"), COMMUNITY("Community");
	
	private final String type;
	
	private ConferenceType(String type) {
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
