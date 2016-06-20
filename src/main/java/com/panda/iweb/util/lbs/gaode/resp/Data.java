package com.panda.iweb.util.lbs.gaode.resp;

import java.util.List;

public class Data extends DataBase {
	private String _id;
	private String _createtime;
	private String _updatetime;
	private String _province;
	private String _city;
	private String _district;
	private Integer _distance;
	private List<Image> _image;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_createtime() {
		return _createtime;
	}

	public void set_createtime(String _createtime) {
		this._createtime = _createtime;
	}

	public String get_updatetime() {
		return _updatetime;
	}

	public void set_updatetime(String _updatetime) {
		this._updatetime = _updatetime;
	}

	public String get_province() {
		return _province;
	}

	public void set_province(String _province) {
		this._province = _province;
	}

	public String get_city() {
		return _city;
	}

	public void set_city(String _city) {
		this._city = _city;
	}

	public String get_district() {
		return _district;
	}

	public void set_district(String _district) {
		this._district = _district;
	}

	public List<Image> get_image() {
		return _image;
	}

	public void set_image(List<Image> _image) {
		this._image = _image;
	}

	public Integer get_distance() {
		return _distance;
	}

	public void set_distance(Integer _distance) {
		this._distance = _distance;
	}

}
