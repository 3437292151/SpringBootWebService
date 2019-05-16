package com.yu.util;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.transport.http.HTTPSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: yuchanglong
 * @Date: 2019-5-16
 * @Description: webService 上下文工具
 */
public class WebServiceContextUtil {

    //获取message
    public static Message getMessage(){
        return  PhaseInterceptorChain.getCurrentMessage();
    }

    //获取Request
    public static HttpServletRequest getRequest(){

        return (HttpServletRequest)getMessage().get(AbstractHTTPDestination.HTTP_REQUEST);
    }

    //获取Response
    public static HttpServletResponse getResponse(){
        return (HttpServletResponse) getMessage().get(AbstractHTTPDestination.HTTP_RESPONSE);
    }

    //获取session
    public static HttpSession getHttpSession(){
        return getRequest().getSession();
    }

    //获取远程地址
    public static String getRemoteAddr(){
        return getRequest().getRemoteAddr();
    }

    //获取 某个header值
    public static String getHeader(String key){
        return getRequest().getHeader(key);
    }

    //获取某个属性
    public static Object getAttribute(String key){
        return getRequest().getAttribute(key);
    }

}
