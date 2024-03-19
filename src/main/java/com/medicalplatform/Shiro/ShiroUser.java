package com.medicalplatform.Shiro;

import java.io.Serializable;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
public class ShiroUser implements Serializable {

        /**
        * 标识
        */
        private String id;
        /**
        * 名称
        */
        private String name;
        /**
        * 登录用户名
        */
        private String username;
        /**
        * 用户类型 user 教师； student 学生
        */
        private String userType;
        /**
        * 用户状态
        */
        private Integer status;
        /**
        * 所属角色
        */
//        private Set<Role> roles;

        public ShiroUser(){

        }

        public ShiroUser(String id,
                        String name,
                        String username,
                        String userType,
                        Integer status
                        //Set<Role> roles
        ) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.userType = userType;
            if (null == status) {
                status = 0;
            }
            this.status = status;
           /// this.roles = roles;
        }
}
