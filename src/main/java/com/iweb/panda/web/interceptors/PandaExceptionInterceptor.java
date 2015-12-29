/*
 * @(#)SpringExceptionInterceptor.java Created on 2015年1月19日 Copyright (c) 2015 ZDSoft Networks, Inc. All rights
 * reserved. $Id$
 */
package com.iweb.panda.web.interceptors;

import com.iweb.panda.common.enums.ErrorCode;
import com.iweb.panda.common.exceptions.PandaException;
import com.iweb.panda.common.resp.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 不必在Controller中对异常进行处理，抛出即可，由此异常解析器统一控制。<br>
 * ajax请求（有@ResponseBody的Controller）发生错误，输出JSON。<br>
 * 页面请求（无@ResponseBody的Controller）发生错误，输出错误页面。<br>
 * 需要与AnnotationMethodHandlerAdapter使用同一个messageConverters<br>
 * Controller中需要有专门处理异常的方法。
 */
public class PandaExceptionInterceptor extends ExceptionHandlerExceptionResolver {

    private final Logger        logger           = LoggerFactory.getLogger(getClass());

    private static final String defaultErrorView = "/page/404";

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response,
                                                           HandlerMethod handlerMethod, Exception e) {

        Method method = handlerMethod.getMethod();
        // 如果返回类型是ModelAndView
        if (method.getReturnType().getName().equals(ModelAndView.class.getName())) {
            return new ModelAndView(defaultErrorView);
        } else {
            try {
                response.setContentType("application/json; charset=utf-8");
                PrintWriter writer = response.getWriter();
                Result result = new Result();
                if (e instanceof PandaException) {
                    logger.error(e.getMessage());
                    result.setErrcode(((PandaException) e).getErrorCode());
                }
                // 主键冲突
                else if (e instanceof org.springframework.dao.DuplicateKeyException) {
                    logger.error(e.getMessage());
                    // result.setCode(ErrorCode.ERROR_REPEAT);
                } else if (e.getCause() instanceof java.net.ConnectException) {
                    logger.error(e.getMessage());
                    // result.setCode(ErrorCode.ACTION_NOT_EXIST);
                } else {
                    // 未知错误，打印堆栈
                    e.printStackTrace();
                    // result.setCode(ErrorCode.UNKNOW);
                }
                // writer.write(JSON.toJSONString(result));
                return new ModelAndView();
            } catch (IOException ioe) {
                logger.error("exception io error");
            } finally {
                try {
                    response.getWriter().close();
                } catch (IOException e1) {
                    logger.error("exception close error");
                }
            }
            return new ModelAndView(defaultErrorView);
        }
    }
}
