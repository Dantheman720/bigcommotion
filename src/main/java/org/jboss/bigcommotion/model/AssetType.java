package org.jboss.bigcommotion.model;

public enum AssetType {
	ACTIVITY("Activity"), ASSET("Asset");
	
	AssetType(String type){
		this.type = type;
	}
	
	private final String type;
	
	public String getType(){
		return type;
	}
	
}
