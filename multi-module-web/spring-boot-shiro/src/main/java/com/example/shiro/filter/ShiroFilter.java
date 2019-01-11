package com.example.shiro.filter;

import com.example.common.util.JWTUtil;
import com.example.service.service.UserDOService;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * 自定义Shiro过滤器，所有请求的请求头需携带token
 * @author Created by L.C.Y on 2018-8-28
 */
@Component
public class ShiroFilter extends AccessControlFilter {

    @Resource
    UserDOService userDOService;

    private Logger logger = LoggerFactory.getLogger(ShiroFilter.class);

    /**
     * 关闭注册，使Shiro默认的anon生效
     * @param shiroFilter 自定义的
     * @return registrationBean
     */
    @Bean
    public FilterRegistrationBean registrationBean(ShiroFilter shiroFilter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(shiroFilter);
        registrationBean.setEnabled(false);
        return registrationBean;
    }



    /**
     *返回false
     * @param servletRequest req
     * @param servletResponse res
     * @param o object
     * @return 返回结果是false的时候才会执行下面的onAccessDenied方法
     * @exception Exception e
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    /**
     * 从请求头获取token并验证，验证通过后交给realm进行登录
     * @param servletRequest req
     * @param servletResponse res
     * @return 返回结果为true时，表明登录认证通过，执行controller层
     * @throws Exception e
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");
        String uri = request.getRequestURI(); // 返回请求URL
        String method = request.getMethod();    // 返回请求方法
        String requestUrl = method+":"+uri;
        logger.info("请求方法拼接："+requestUrl);

        // token判空
        if (token == null) {
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.getWriter().print("{\"code\":300,\"message\":\"用户未登录，请重新登录！\"}");
            return false;
        }

        // 权限判断
        if (JWTUtil.verify(token)) {

            // 获取用户ID和权限
            String id = String.valueOf(Objects.requireNonNull(JWTUtil.parse(token)).get("userId"));
            List<String> perms = userDOService.listStringPerms(Long.valueOf(id));
            for (String perm : perms) {
                String[] p = perm.split(":");

                // 判断权限是否属于该URL，不属于返回登录页
                if (p[0].equals(method) && uri.contains(p[1])) {
                    return true;
                }
            }
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.getWriter().print("{\"code\":401,\"message\":\"该用户没有操作权限！\"}");
            return false;
        }else{
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.getWriter().print("{\"code\":300,\"message\":\"token已过期，请重新登录！\"}");
            return false;
        }

    }

}
