package org.jboss.bigcommotion.model;

public enum LeadScore {
	
	NONE("None"), LOW("Low"), MEDIUM("Medium"), HIGH("High");
	
	private final String type;
	
	LeadScore(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
}
