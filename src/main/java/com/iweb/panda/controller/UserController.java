package com.iweb.panda.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iweb.panda.common.enums.ErrorCode;
import com.iweb.panda.common.resp.JsonpResult;
import com.iweb.panda.common.resp.Result;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @RequestMapping(value = "/getUserInfo")
    public JsonpResult getUserInfo(HttpServletRequest req) {
        logger.info("getUserInfo");
        return result(req, new Result(ErrorCode.SUCCESS));
    }
}
