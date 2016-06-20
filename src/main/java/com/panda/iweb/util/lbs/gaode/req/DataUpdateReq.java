package com.panda.iweb.util.lbs.gaode.req;

import com.panda.iweb.util.lbs.gaode.resp.DataBase;


//只需把需要参与筛选和排序的字段作为扩展字段
public class DataUpdateReq extends DataBase {
	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
