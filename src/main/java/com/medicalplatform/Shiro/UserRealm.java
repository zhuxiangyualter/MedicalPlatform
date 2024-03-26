package com.medicalplatform.Shiro;

import com.medicalplatform.Service.Impl.UserServiceImpl;
import com.medicalplatform.Service.UserService;
import com.medicalplatform.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@Slf4j
@Component
@Service
public class UserRealm extends AuthorizingRealm {
    private UserService UserService;
    @Autowired
    private void setUserService (UserService userService){
        this.UserService = userService;
    };

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 添加角色和权限信息
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.获取用户信息
        String username = authenticationToken.getPrincipal().toString();

        //2.
        User user = UserService.findByName(username);
        if (user != null) {
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    user.getPassword(),
                    ByteSource.Util.bytes("salt"),
                    authenticationToken.getPrincipal().toString()
            );
            return info;
        }
        return null;
    }
    // 用于认证登录
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        //1获取身份信息
//        String principal = token.getPrincipal().toString();
//        // 2获取凭证信息
//        String pwd = new String((char[]) token.getCredentials());
//        System.out.println("认证用户信息"+principal+"密码"+pwd);
//        // 3获取数据库种存储的用户信息
//        if (principal.equals("zhangsan")) {
//            // 数据库中存储的密码信息
//            String pwdInfo = "5719d28ce34408a6f91faaafa724c0a5";
////            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, pwdInfo, getName());
//            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(), pwdInfo,
//                    ByteSource.Util.bytes("z3"), token.getPrincipal().toString());
//            return authenticationInfo;
//        }
//        // 4创建封装校验逻辑对象，封装数据返回
//        //
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//
//        // 模拟从数据库中获取用户信息，您需要替换成实际的用户数据查询逻辑
//        String username = usernamePasswordToken.getUsername();
//        String passwordFromDatabase = "hashed_password"; // 从数据库中获取的已加密密码
//        if (passwordFromDatabase == null) {
//            throw new UnknownAccountException("用户不存在");
//        }
//
//        return new SimpleAuthenticationInfo(username, passwordFromDatabase, getName());
//    }


}
