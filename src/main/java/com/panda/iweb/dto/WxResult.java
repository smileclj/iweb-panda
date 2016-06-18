package com.panda.iweb.dto;

public class WxResult<T> {
	private Boolean ok;
	private String errorMsg;
	private Integer expiresIn;
	private T dataView;

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public T getDataView() {
		return dataView;
	}

	public void setDataView(T dataView) {
		this.dataView = dataView;
	}

}
