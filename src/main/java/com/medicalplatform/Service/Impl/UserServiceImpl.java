package com.medicalplatform.Service.Impl;

import com.medicalplatform.Service.UserService;
import com.medicalplatform.entity.User;
import com.medicalplatform.repository.UserRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User findByUserRole(String userRole) {
        return null;
    }

    @Override
    public User findByUserid(Integer userid) {
        return null;
    }

    @Override
    public void deleteByUserid(Integer userid) {

    }

    @Override
    public void resetPassword(Integer userid){
        User user = userService.findById(userid);
        if (user != null){
            String init = "123456";
            String encodedPassword = new Md5Hash(init, "salt", 2).toString();
            user.setPassword(encodedPassword);
            userService.update(user);

        }

    }

    @Override
    public void changePassword(Integer userid, String password) {

    }

    @Override
    public void changeUserRole(Integer userid, String userRole) {

    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void importData(String eventKey) {

    }

    @Override
    public void export(String token) {

    }

    @Override
    public List<User> getAllUser() {
        return null;
    }


    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public <X extends Throwable> User findById(Integer integer, Supplier<? extends X> exceptionSupplier) throws X {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Stream<User> findAll() {
        return null;
    }

    @Override
    public Stream<User> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public Optional<User> findOneWithPredicate(Predicate predicate) {
        return Optional.empty();
    }

    @Override
    public Stream<User> findAllWithPredicate(Predicate predicate) {
        return null;
    }

    @Override
    public Stream<User> findAllSortedWithPredicate(Predicate predicate, Sort sort) {
        return null;
    }

    @Override
    public Stream<User> findAllOrderedWithPredicate(Predicate predicate, OrderSpecifier<?>... orders) {
        return null;
    }

    @Override
    public Stream<User> findAllOrdered(OrderSpecifier<?>... orders) {
        return null;
    }

    @Override
    public Page<User> findAllPagedWithPredicate(Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public long countByPredicate(Predicate predicate) {
        return 0;
    }

    @Override
    public boolean existsByPredicate(Predicate predicate) {
        return false;
    }

    @Override
    public boolean notExistsByPredicate(Predicate predicate) {
        return false;
    }

    @Override
    public void importData(String eventKey, MultipartFile file) {

    }
}
