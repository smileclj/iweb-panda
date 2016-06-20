package com.panda.iweb.util.lbs.gaode.resp;

import java.util.List;

public class DataSearchResp extends BaseLbsResp {
	private String count;
	private List<Data> datas;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}

}
