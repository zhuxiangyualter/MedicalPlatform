package com.medicalplatform.Shiro;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * Shiro测试类
 */
public class ShiroRun {
    public static void main(String[] args) {
        IniSecurityManagerFactory Factory = new IniSecurityManagerFactory("classpath:/static/shiro.ini");
        SecurityManager securityManager = Factory.getInstance();
        System.out.println("Shiro测试类");
    }
}
