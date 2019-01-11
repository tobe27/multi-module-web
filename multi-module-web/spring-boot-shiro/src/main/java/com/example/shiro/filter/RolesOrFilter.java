package com.example.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 配置多个角色Roles的逻辑为或OR, 如配置 roles[user, admin]，任一角色均有权限
 * AuthorizationFilter抽象类事项了javax.servlet.Filter接口，是个过滤器
 * @author Created by L.C.Y on 2018-10-17
 */
@Component
public class RolesOrFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] rolesArray = (String[]) o;

        // 没有角色限制的，都有权限访问
        if (rolesArray == null ||rolesArray.length == 0) {
            return true;
        }
        // 若当前用户是任一角色都有权限访问
        for (String aRolesArray : rolesArray) {
            if (subject.hasRole(aRolesArray)) {
                return true;
            }
        }
        return false;
    }
}
