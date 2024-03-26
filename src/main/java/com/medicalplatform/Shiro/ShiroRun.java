package com.medicalplatform.Shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * Shiro测试类
 */
public class ShiroRun {
    public static void main(String[] args) {
        // 通过shiro.ini创建SecurityManager
        IniSecurityManagerFactory Factory = new IniSecurityManagerFactory("classpath:static/shiro.ini");

        SecurityManager securityManager = Factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //创建token对象  web从页面传递过来
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3");
        //登录
        try {
            subject.login(token);
            System.out.println("登录成功");
            //判断是否有admin角色
            if (subject.hasRole("admin")) {
                System.out.println("有admin角色");
                //判断是否有权限
                boolean isPermitted = subject.isPermitted("user:delete");
                System.out.println("是否有删除权限：" + isPermitted);
                subject.checkPermission("user:delete");
            }
            else {
                System.out.println("没有admin角色");
            }
        }

        catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在");
        }
        catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }
        catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println("Shiro测试类");
    }
}
