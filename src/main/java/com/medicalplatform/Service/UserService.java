package com.medicalplatform.Service;

import com.medicalplatform.Service.Basic.BasicService;
import com.medicalplatform.Service.Basic.ExportService;
import com.medicalplatform.Service.Basic.ImportableService;
import com.medicalplatform.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * 用户 Service 接口
 * 根据姓名、id、角色查询用户
 * 导出、导入用户数据
 * 增加删除用户
 * 修改、重置用户密码
 * 修改用户角色
 */
public interface UserService extends BasicService<User,Integer>, ExportService, ImportableService {
    User findByName(String name);

    User findByUserRole(String userRole);
    User findByUserid(Integer userid);
    void deleteByUserid(Integer userid);
    void resetPassword(Integer userid);
    void changePassword(Integer userid, String password);
    void changeUserRole(Integer userid, String userRole);
    void add(User user);
    void delete(User user);
    void update(User user);
    void importData(String eventKey);
    void export(String token);
    List<User> getAllUser();
}


