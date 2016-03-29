package com.panda.iweb.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panda.iweb.common.enums.ErrorCode;
import com.panda.iweb.common.resp.JsonpResult;
import com.panda.iweb.common.resp.Result;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@RequestMapping(value = "/getUserInfo")
	public JsonpResult getUserInfo(int a, double b, String c, HttpServletRequest req) {
		logger.info("getUserInfo");
		return result(req, new Result(ErrorCode.SUCCESS));
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void get(String name) {
		logger.info("get:{}", name);
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void post(String name) {
		logger.info("post:{}", name);
	}

	@RequestMapping(value = "/getAndPost")
	public void getAndPost(String name) {
		logger.info("getAndPost:{}", name);
	}

	@RequestMapping(value = "/testDate1")
	public void testDate(String d) {
		logger.info(d);
	}

	@RequestMapping(value = "/testDate2")
	public void testDate(Date d) {
		logger.info(d.getTime() + "");
	}

	@RequestMapping(value = "/testDate3")
	public void testDate(DateIns dd) {
		logger.info(dd.getD().getTime() + "");
	}
}

class DateIns {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date d;

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

}
