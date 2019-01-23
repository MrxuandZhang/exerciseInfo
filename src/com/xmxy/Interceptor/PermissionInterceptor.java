package com.xmxy.Interceptor;

import com.xmxy.entity.UserInfo;
import com.xmxy.util.CommonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo user=(UserInfo) request.getSession().getAttribute("user");
        if (CommonUtil.isNull(user)){
            request.getSession().setAttribute("loginMsg","请先登录");
            response.getWriter().write("<a href='/login.jsp' target='_top' id='go' >1</a>  <script type='text/javascript'>" +
                    "document.getElementById('go').click()" +
                    "</script>");
            response.getWriter().close();
           return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
