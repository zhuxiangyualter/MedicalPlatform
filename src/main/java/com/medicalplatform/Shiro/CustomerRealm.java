package com.medicalplatform.Shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 添加角色和权限信息
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        // 模拟从数据库中获取用户信息，您需要替换成实际的用户数据查询逻辑
        String username = usernamePasswordToken.getUsername();
        String passwordFromDatabase = "hashed_password"; // 从数据库中获取的已加密密码
        if (passwordFromDatabase == null) {
            throw new UnknownAccountException("用户不存在");
        }

        return new SimpleAuthenticationInfo(username, passwordFromDatabase, getName());
    }
}
