package com.panda.iweb.util.lbs.gaode.resp;

public class BaseLbsResp {
	private Integer status;
	private String info;
	private Integer infocode;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getInfocode() {
		return infocode;
	}

	public void setInfocode(Integer infocode) {
		this.infocode = infocode;
	}

}
