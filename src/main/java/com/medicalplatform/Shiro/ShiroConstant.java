package com.medicalplatform.Shiro;

/**
 * Shiro配置所需的一些常量
 * @author zsm@shuyuntu.com
 */
public class ShiroConstant {
    /**
     * 默认的密码加密算法
     */
    public static final String DEFAULT_ALGORITHM_NAME = "MD5";
    /**
     * 记住我 cookie 名
     */
    public static final String REMEMBER_ME_COOKIE_NAME = "rememberMe";
    /**
     * rememberMe cookie加密的密钥
     * key=SpringBoot
     */
    public static final String REMEMBER_ME_CIPHER_KEY = "U3ByaW5nQm9vdA==";
    /**
     * 所有认证相关的 url 前缀
     */
    public static final String AUTHENTICATION_URL_PREFIX = "/authentication";
    /**
     * 默认记住我最大时长 (一周)
     */
    public static final int DEFAULT_REMEMBER_ME_MAX_AGE = 7 * 24 * 60 * 60;
    /**
     * 更改 sessionId 存在cookie中的名称
     */
    public static final String SESSION_ID_NAME = "syt.sessionId";

    /**
     * 当前登录用户存在session中的名称
     */
    public static final String SESSION_NAME_CURRENT_USER = "currentUser";
}
