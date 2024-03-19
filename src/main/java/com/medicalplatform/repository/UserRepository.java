package com.medicalplatform.repository;

import com.medicalplatform.entity.User;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
public class UserRepository implements QuerydslPredicateExecutor<T> {

    @Override
    public Optional<T> findOne(Predicate predicate) {
        return Optional.empty();
    }

    @Override
    public Iterable<T> findAll(Predicate predicate) {
        return null;
    }

    @Override
    public Iterable<T> findAll(Predicate predicate, Sort sort) {
        return null;
    }

    @Override
    public Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        return null;
    }

    @Override
    public Iterable<T> findAll(OrderSpecifier<?>... orders) {
        return null;
    }

    @Override
    public Page<T> findAll(Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Predicate predicate) {
        return 0;
    }

    @Override
    public boolean exists(Predicate predicate) {
        return false;
    }

    @Override
    public <S extends T, R> R findBy(Predicate predicate, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
