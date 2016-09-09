package com.panda.iweb.web.interceptors;

import com.panda.iweb.common.enums.ErrorCode;
import com.panda.iweb.common.exceptions.PandaException;
import com.panda.iweb.common.resp.Result;
import com.panda.iweb.util.JsonUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huixiangdou on 2016/9/9.
 */
public class PandaExceptionInterceptor2 extends SimpleMappingExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        // 如果返回类型是ModelAndView
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            Result result = new Result();
            if (e instanceof PandaException) {
                logger.error(e.getMessage());
                result.setError(((PandaException) e).getErrorCode());
            }
            // 主键冲突
            else if (e instanceof org.springframework.dao.DuplicateKeyException) {
                logger.error(e.getMessage());
                result.setError(ErrorCode.ERROR_REPEAT);
            } else if (e.getCause() instanceof java.net.ConnectException) {
                logger.error(e.getMessage());
                result.setError(ErrorCode.ACTION_NOT_EXIST);
            } else {
                // 未知错误，打印堆栈
//                    e.printStackTrace();
//                    logger.error(e.getMessage(), e);
                result.setError(ErrorCode.UNKNOW);
            }
            writer.write(JsonUtil.toJsonString(result));
            return null;
        } catch (IOException ioe) {
            logger.error("exception io error");
        } finally {
            try {
                response.getWriter().close();
            } catch (IOException e1) {
                logger.error("exception close error");
            }
        }
        return null;
    }
}
