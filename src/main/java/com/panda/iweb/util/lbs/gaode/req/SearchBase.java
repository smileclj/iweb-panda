package com.panda.iweb.util.lbs.gaode.req;

public class SearchBase {
	private String keywords;
	private String filter;
	private String sortrule;
	private Integer limit;
	private Integer page;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getSortrule() {
		return sortrule;
	}

	public void setSortrule(String sortrule) {
		this.sortrule = sortrule;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
