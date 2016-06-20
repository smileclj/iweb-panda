package com.panda.iweb.util.lbs.gaode.resp;

//数据基本信息基类
public class DataBase {
	private String _name; // 数据名称
	private String _location; // 104.394729,31.125698
	// private String coordtype;
	private String _address;
	// ext
	private String phone;
	private String type;
	private Integer exchange_rate; // 卡券兑换率
	private Integer hasCoupon; // 是否有券

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_location() {
		return _location;
	}

	public void set_location(String _location) {
		this._location = _location;
	}

	public String get_address() {
		return _address;
	}

	public void set_address(String _address) {
		this._address = _address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(Integer exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	public Integer getHasCoupon() {
		return hasCoupon;
	}

	public void setHasCoupon(Integer hasCoupon) {
		this.hasCoupon = hasCoupon;
	}

}
