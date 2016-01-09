package com.iweb.panda.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iweb.panda.common.resp.JsonpResult;
import com.iweb.panda.common.resp.Result;

public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected JsonpResult result(HttpServletRequest req, Result result) {
        return new JsonpResult(result, req.getParameter("callback"));
    }
}
