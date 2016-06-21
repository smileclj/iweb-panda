package com.panda.iweb.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
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
	public JsonpResult getUserInfo(Integer a, Double b, String c, HttpServletRequest req) {
		logger.info("authType:{}", req.getAuthType());
		logger.info("characterEncoding:{}", req.getCharacterEncoding());
		logger.info("contentType:{}", req.getContentType());
		logger.info("contextPath:{}", req.getContextPath());
		logger.info("localAddr:{}", req.getLocalAddr());
		logger.info("localName:{}", req.getLocalName());
		logger.info("localPort:{}", req.getLocalPort());
		logger.info("method:{}", req.getMethod());
		logger.info("pathInfo:{}", req.getPathInfo());
		logger.info("pathTranslated:{}", req.getPathTranslated());
		logger.info("protocol:{}", req.getProtocol());
		logger.info("queryString:{}", req.getQueryString());
		logger.info("remoteAddr:{}", req.getRemoteAddr());
		logger.info("remoteHost:{}", req.getRemoteHost());
		logger.info("remoteUser:{}", req.getRemoteUser());
		logger.info("remotePort:{}", req.getRemotePort());
		logger.info("requestSessionId:{}", req.getRequestedSessionId());
		logger.info("requestUri:{}", req.getRequestURI());
		logger.info("scheme:{}", req.getScheme());
		logger.info("serverName:{}", req.getServerName());
		logger.info("serverPort:{}", req.getServerPort());
		logger.info("servletPath:{}", req.getServletPath());
		logger.info("contentLength:{}", req.getContentLength());
		logger.info("contentLengthLong:{}", req.getContentLengthLong());
		logger.info("remotePort:{}", req.getRemotePort());
		logger.info("requestUrl:{}", req.getRequestURL().toString());
		logger.info("realpath1{}", req.getServletContext().getRealPath("/"));
		logger.info("realpath2{}", req.getServletContext().getRealPath(""));

		return result(req, new Result(ErrorCode.SUCCESS));
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void get(String name, BigDecimal decimal) {
		logger.info("get,name:{},decimal:{}", name, decimal);
	}

	@RequestMapping(value = "/postCommon1")
	public void postCommon1(String id, String name) {
		logger.info("id:{},name:{}", id, name);
	}

	@RequestMapping(value = "/postCommon2")
	public void postCommon2(@RequestBody String str, String id, String name) {
		logger.info("id:{},name:{}", id, name);
		logger.info("str:{}", str);
	}

	@RequestMapping(value = "/postJson")
	public void postJson(@RequestBody String str) {
		logger.info("str:{}", str);
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
