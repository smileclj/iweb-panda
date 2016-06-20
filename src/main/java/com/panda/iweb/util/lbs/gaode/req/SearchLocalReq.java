package com.panda.iweb.util.lbs.gaode.req;

public class SearchLocalReq extends SearchBase {
	private String city; // 必填

	public SearchLocalReq() {
	}

	public SearchLocalReq(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
