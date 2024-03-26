package com.medicalplatform.Controller;

import com.medicalplatform.Service.UserService;
import com.medicalplatform.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@RestController("/user")
public class UserController {
    private final UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String name, String pwd, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(name,pwd);
        String role = userService.findByName(name).getUserRole();
        try{
            subject.login(token);
            session.setAttribute("user",token.getPrincipal().toString());
            if ("admin".equals(role)) {
                return "redirect:/admin/init";
            } else {
                return "redirect:/common/init";
            }

        }catch (UnknownAccountException e) {
            e.printStackTrace();
            return "用户名不存在";
        }
        catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "密码错误";
        }

        catch (AuthenticationException e){
            e.printStackTrace();
            return "登录失败";
        }
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/getallUser", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUser() {
        List<User> Users = userService.getAllUser();
        return ResponseEntity.ok(Users);
    }
    public ResponseEntity<User> getUserById(Integer id) {
        User user = userService.findByUserid(id);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> getUserByName(String name) {
        User user = userService.findByName(name);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> getUserByRole(String role) {
        User user = userService.findByUserRole(role);
        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> deleteUserById(Integer id) {
        userService.deleteByUserid(id);
        return ResponseEntity.ok("Delete Success");
    }
    public ResponseEntity<String> resetPassword(Integer id) {
            userService.resetPassword(id);
            return ResponseEntity.ok("Reset Success");

    }
    @RequestMapping(value = "/changepwd", method = RequestMethod.POST)
    public ResponseEntity<String> changePassword(Integer id, String password) {
        userService.changePassword(id, password);
        return ResponseEntity.ok("Change Success");
    }
    @RequestMapping(value = "/changerole", method = RequestMethod.POST)
    public ResponseEntity<String> changeUserRole(Integer id, String role) {
        userService.changeUserRole(id, role);
        return ResponseEntity.ok("Change Success");
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresRoles("admin")
    public ResponseEntity<String> addUser(User user) {
        userService.add(user);
        return ResponseEntity.ok("Add Success");
    }
    public ResponseEntity<String> deleteUser(User user) {
        userService.delete(user);
        return ResponseEntity.ok("Delete Success");
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> updateUser(User user) {
        userService.update(user);
        return ResponseEntity.ok("Update Success");
    }
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public ResponseEntity<String> importData(String eventKey) {
        userService.importData(eventKey);
        return ResponseEntity.ok("Import Success");
    }
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ResponseEntity<String> export(String token) {
        userService.export(token);
        return ResponseEntity.ok("Export Success");
    }

}
