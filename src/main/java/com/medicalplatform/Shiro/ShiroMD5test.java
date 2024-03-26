package com.medicalplatform.Shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
public class ShiroMD5test {
    public static void main(String[] args) {
        String password = "z3";
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println(md5Hash);
        //带盐的加密,盐值是一个随机字符串,即明文后拼接新字符串
        String salt = "z";
        Md5Hash md5Hash1 = new Md5Hash(password, salt);
        System.out.println(md5Hash1);
        //加密次数
        Md5Hash md5Hash2 = new Md5Hash(password, salt, 3);
        System.out.println(md5Hash2);
        System.out.println(md5Hash2.toHex());
        //使用父类进行加密
        SimpleHash simpleHash = new SimpleHash("md5", password, salt, 1024);
    }
}
