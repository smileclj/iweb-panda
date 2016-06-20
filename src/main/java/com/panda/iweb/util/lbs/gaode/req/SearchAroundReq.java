package com.panda.iweb.util.lbs.gaode.req;

public class SearchAroundReq extends SearchBase {
	private String center; // 必填,经度和纬度用","分割 ,经纬度小数点后不得超过6位
	private Integer radius;

	public SearchAroundReq() {
	}

	public SearchAroundReq(String center) {
		this.center = center;
	}

	public SearchAroundReq(String center, Integer radius) {
		this.center = center;
		this.radius = radius;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}
}
