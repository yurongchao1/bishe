package com.chao.bishe.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

    public static void setAttr(HttpServletRequest request, String key, Object value){
                 request.getSession(true).setAttribute(key, value);
              }
    public static Object getAttr(HttpServletRequest request,String key){
                  return request.getSession(true).getAttribute(key);
              }

    public static void removeAttr(HttpServletRequest request,String key){
                  request.getSession(true).removeAttribute(key);
              }
}
