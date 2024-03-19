package com.medicalplatform.Utils;

import cn.hutool.core.util.RandomUtil;
import com.medicalplatform.Shiro.ShiroConstant;
import com.medicalplatform.Shiro.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
public class AuthUtils {
    private AuthUtils() {
    }



    /**
     * 向 session 中添加属性
     *
     * @param key   key
     * @param value value
     */
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取 session
     *
     * @return session
     */
    public static Session getSession() {
        return getCurrentSubject().getSession();
    }

    /**
     * 获得当前的 subject
     *
     * @return Subject
     */
    public static Subject getCurrentSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        if (getCurrentSubject() != null) {
            getCurrentSubject().logout();
        }
    }

    /**
     * 获取当前登录用户对象 user 或 student
     *
     * @return 登录用户对象 user 或 student
     */
    @SuppressWarnings("unchecked")
    public static <U> U currentLoginUser() {
        return (U) getSessionAttribute(ShiroConstant.SESSION_NAME_CURRENT_USER);
    }

    /**
     * 根据 key 从 session 中获取属性
     *
     * @param key key
     * @return attribute
     */
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 判断是否已经过认证
     */
    public static boolean isAuthenticated() {
        return getCurrentSubject().isAuthenticated();
    }

    /**
     * 获取登录的用户
     *
     * @return 当前登录的用户
     */
    public static ShiroUser getLoginUser() {
        final ShiroUser principal = (ShiroUser) getCurrentSubject().getPrincipal();
        if (principal != null) {
            return principal;
        } else {
            throw new IllegalStateException("当前无登录用户");
        }
    }

    /**
     * 获取当前用户最大权限级别
     * 数据权限级别
     * 0-> 所有(admin)，
     * 1->仅限本学院(院系管理员)，
     * 2->仅限辅导的班级(辅导员)
     * 3->其他教职工(无实际功能)、心理咨询师（仅心理咨询功能）
     */
//    public static int getMaxAuthLevel() {
//        int max = 3;
//        for (Role role : getLoginUser().getRoles()) {
//            int level = Integer.parseInt(role.getAuthorityLevel());
//            if (level < max) {
//                max = level;
//            }
//        }
//        return max;
//    }


//    public static String generateRandomStudentId() {
//        return FieldContains.UNDEFINED_STUDENT_ID_PREFIX + RandomUtil.randomString(UnusualConst.STUDENT_ID_LENGTH);
//    }

    /**
     * 个人上传文件夹
     * @return
     */
//    public static String selfUploadPath(){
//        Object pathObj = getSession().getAttribute("selfUploadPath");
//        if(pathObj == null){
//            ShiroUser shiroUser = getLoginUser();
//            String path = String.format("/%s/%s/", shiroUser.getUserType(), shiroUser.getUsername());
//            getSession().setAttribute("selfUploadPath", path);
//            return path;
//        }else {
//            return pathObj.toString();
//        }
//    }

    /**
     * 判断登录用户是否是超级管理员
//     */
//    public static boolean isAdmin(){
//        ShiroUser loginUser = AuthUtils.getLoginUser();
//        //fixme 此处使用超级管理员名称"admin"判断
//        boolean isAdmin = false;
//        for (Role role : loginUser.getRoles()) {
//            if ("admin".equals(role.getName())) {
//                isAdmin = true;
//                break;
//            }
//        }
//        return isAdmin;
//    }

}
