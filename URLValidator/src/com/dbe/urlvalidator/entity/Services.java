package com.dbe.urlvalidator.entity;

public class Services {
	
	private String ServiceID;
	private String ServiceType;
	private String ServiceURL;
	private String ServiceUser;
	private String ServicePassword;
	
	public Services(String serviceID, String serviceType, String serviceURL) {
		super();
		ServiceID = serviceID;
		ServiceType = serviceType;
		ServiceURL = serviceURL;
	}
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}
	public String getServiceType() {
		return ServiceType;
	}
	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
	public String getServiceURL() {
		return ServiceURL;
	}
	public void setServiceURL(String serviceURL) {
		ServiceURL = serviceURL;
	}
	public String getServiceUser() {
		return ServiceUser;
	}
	public void setServiceUser(String serviceUser) {
		ServiceUser = serviceUser;
	}
	public String getServicePassword() {
		return ServicePassword;
	}
	public void setServicePassword(String servicePassword) {
		ServicePassword = servicePassword;
	}
	
	

}
