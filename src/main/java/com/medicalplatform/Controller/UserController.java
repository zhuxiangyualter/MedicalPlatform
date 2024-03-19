package com.medicalplatform.Controller;

import com.medicalplatform.Service.UserService;
import com.medicalplatform.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@RestController("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
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
    public ResponseEntity<String> deleteUserById(Integer id) {
        userService.deleteByUserid(id);
        return ResponseEntity.ok("Delete Success");
    }
    public ResponseEntity<String> resetPassword(Integer id) {
        userService.resetPassword(id);
        return ResponseEntity.ok("Reset Success");
    }
    public ResponseEntity<String> changePassword(Integer id, String password) {
        userService.changePassword(id, password);
        return ResponseEntity.ok("Change Success");
    }
    public ResponseEntity<String> changeUserRole(Integer id, String role) {
        userService.changeUserRole(id, role);
        return ResponseEntity.ok("Change Success");
    }
    public ResponseEntity<String> addUser(User user) {
        userService.add(user);
        return ResponseEntity.ok("Add Success");
    }
    public ResponseEntity<String> deleteUser(User user) {
        userService.delete(user);
        return ResponseEntity.ok("Delete Success");
    }
    public ResponseEntity<String> updateUser(User user) {
        userService.update(user);
        return ResponseEntity.ok("Update Success");
    }
    public ResponseEntity<String> importData(String eventKey) {
        userService.importData(eventKey);
        return ResponseEntity.ok("Import Success");
    }
    public ResponseEntity<String> export(String token) {
        userService.export(token);
        return ResponseEntity.ok("Export Success");
    }

}
