package org.zpf.interceptor;

import org.apache.commons.io.FileUtils;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zpf.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器必须实现HandlerInterceptor接口
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    //不拦截/loginForm和/login2请求
    private static final String[] IGNORE_URI = {"/loginForm", "/login2"};

    /**
     * 该方法时进行处理器拦截用的,该方法将在Controller处理之前进行调用
     * 该方法的返回值为True时拦截器才继续往下执行,该方法的返回值为False时整个请求就结束.
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("authorizationInterceptor preHandel");
        //flag变量用于判断用户是否登录,默认为false
        boolean flag = false; //如果url在定义的数组中放行让其继续执行,如果不在则进行拦截验证是否登录,如果没有登录则转发到登录页.否则放行.
        //获取用户请求的路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        //获取用户请是否需要拦截
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }

        //拦截请求
        if (!flag) {
            //1.获取session中的用户
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            //2.判断用户是否已经登录
            if (user == null) {
                //如果用户没有登录,则设置提示信息,跳转到登录页面
                System.out.println("AuthorizationInterceptor拦截请求:");
                httpServletRequest.setAttribute("message", "请先登录在访问网站");
                httpServletRequest.getRequestDispatcher("/loginForm").forward(httpServletRequest, httpServletResponse);

            } else {
                //如果用户已经登录,则验证通过,放行
                System.out.println("AuthorizationInterceptor 放行请求:");
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 该方法在Controller的方法调用之后执行,方法中可以对modelandview进行操作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    /**
     * 该方法将在整个请求完成之后执行,主要作用用于清理资源
     * 该方法只能在当前Interceptor的PreHandler方法的返回值为True时才会执行
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion");
    }
}
