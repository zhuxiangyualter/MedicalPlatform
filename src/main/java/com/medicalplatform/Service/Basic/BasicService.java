package com.medicalplatform.Service.Basic;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 抽象的Service接口
 *
 * @param <T>  实体类型
 * @param <ID> 实体主键类型
 * @author am
 */
public interface BasicService<T, ID> {

    /**
     * 保存一个给定的实体. 应当使用返回实体进行后续操作, 保存操作可能会完全改变当前实体
     *
     * @param entity 必须不能为空
     * @return 保存到的实体, 不为空
     */
    <S extends T> S save(S entity);

    /**
     * 保存所有给出的实体
     *
     * @param entities 要保存到实体, 不能为空
     * @return 保存的实体集, 不会返回空
     * @throws IllegalArgumentException 给定的实体为空时抛出
     */
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    /**
     * 通过id检索获得一个实体
     *
     * @param id id, 实体的主键
     * @return 返回一个Optional对象, 如果查询到实体, 则Optional中保存该实体, 否则返回Optional.empty()
     * @throws IllegalArgumentException                                               给定的id为空时抛出
     */
    T findById(ID id);

    /**
     * 通过id检索获得一个实体
     *
     * @param id                id, 实体的主键
     * @param exceptionSupplier 自定义异常
     * @return 返回一个Optional对象, 如果查询到实体, 则Optional中保存该实体, 否则返回Optional.empty()
     * @throws IllegalArgumentException 给定的id为空时抛出
     * @throws X                        自定义异常
     */
    <X extends Throwable> T findById(ID id, Supplier<? extends X> exceptionSupplier) throws X;

    /**
     * 返回是否存在给定id的实体
     *
     * @param id 要检索的id, 不能为空
     * @return {@literal true} 如果实体存在, {@literal false} 否则.
     * @throws IllegalArgumentException 如果 {@code id} 是 {@literal null}.
     */
    boolean existsById(ID id);

    /**
     * 返回所有的对应类型的实体
     *
     * @return 实体类在数据库对应的所有结果
     */
    Stream<T> findAll();

    /**
     * 返回给定id的对应类型的实体
     *
     * @param ids id集合, 不可为空
     * @return 返回所有符合条件的实体集
     */
    Stream<T> findAllById(Iterable<ID> ids);

    /**
     * 返回实体总数
     *
     * @return 实体总数
     */
    long count();

    /**
     * 通过给定的id删除实体.
     *
     * @param id 实体id, 不可为空.
     * @throws IllegalArgumentException 当id为空时抛出
     */
    void deleteById(ID id);

    /**
     * 删除给定的实体.
     *
     * @param entity 要删除的实体
     * @throws IllegalArgumentException 当给定实体为空时抛出异常.
     */
    void delete(T entity);

    /**
     * 删除给定的多个实体.
     *
     * @param entities 要删除的实体集
     * @throws IllegalArgumentException 当给定实体 {@link Iterable Iterable} 为空时抛出异常
     */
    void deleteAll(Iterable<? extends T> entities);


    /**
     * 返回一个匹配谓词{@link Predicate}的实体,或者没查到时返回{@link Optional#empty()}.
     *
     * @param predicate 查询谓词, 不能为空.
     * @return 一个匹配谓词{@link Predicate}的实体,或者没查到时返回{@link Optional#empty()}.
     * @throws org.springframework.dao.IncorrectResultSizeDataAccessException 如果谓词查询到的结果包含多个数据时抛出
     */
    Optional<T> findOneWithPredicate(Predicate predicate);

    /**
     * 返回一组匹配谓词{@link Predicate}的实体,或者没查到时返回{@link Stream#empty()}.
     *
     * @param predicate 查询谓词, 不能为空.
     * @return 一组匹配谓词{@link Predicate}的实体,或者没查到时返回{@link Stream#empty()}.
     */
    Stream<T> findAllWithPredicate(Predicate predicate);

    /**
     * 返回符合谓词 {@link Predicate} 的所有实体并应用给定的排序规则 {@link Sort}.
     * 如果没有匹配项 则返回一个空流 {@link Stream#empty()}
     *
     * @param predicate 查询谓词 不能为 {@literal null}.
     * @param sort      对于结果的排序规范 {@link Sort} , 可以为空 {@link Sort#empty()}, 但不能为null
     *                  {@literal null}.
     * @return 匹配谓词的所有排序后的结果 {@link Predicate}.
     */
    Stream<T> findAllSortedWithPredicate(Predicate predicate, Sort sort);

    /**
     * 返回符合谓词 {@link Predicate} 的所有实体并应用给定的顺序标识符 {@link OrderSpecifier}s.
     * 如果没有匹配项 则返回一个空流 {@link Stream#empty()}
     *
     * @param predicate 查询谓词, 不能为 {@literal null}
     * @param orders    一组顺序标识符 {@link OrderSpecifier}s 来确定顺序.
     * @return 匹配谓词的所有应用 {@link OrderSpecifier} 的结果 {@link Predicate}.
     */
    Stream<T> findAllOrderedWithPredicate(Predicate predicate, OrderSpecifier<?>... orders);

    /**
     * 返回所有实体并应用给定的顺序标识符 {@link OrderSpecifier}s.
     * 如果没有匹配项 则返回一个空流 {@link Stream#empty()}
     *
     * @param orders 一组顺序标识符 {@link OrderSpecifier}s 来确定顺序.
     * @return 所有应用 {@link OrderSpecifier} 的结果 {@link Predicate}.
     */
    Stream<T> findAllOrdered(OrderSpecifier<?>... orders);

    /**
     * 返回一页 {@link Page} 匹配谓词 {@link Predicate}的实体集
     * 如果没有匹配项 则返回一个空{@link Page}
     *
     * @param predicate 谓词, 不能为 {@literal null}.
     * @param pageable  分页, 可能为 {@link Pageable#unpaged()}, 但不能为 {@literal null}.
     * @return 一页 {@link Page} 匹配谓词的实体 {@link Predicate}.
     */
    Page<T> findAllPagedWithPredicate(Predicate predicate, Pageable pageable);

    /**
     * 返回匹配谓词{@link Predicate}的实体数量.
     *
     * @param predicate 计数谓词, 不能为 {@literal null}.
     * @return 匹配谓词 {@link Predicate} 的实体数量.
     */
    long countByPredicate(Predicate predicate);

    /**
     * 检查在数据库中是否存在匹配谓词 {@link Predicate} 的实体.
     *
     * @param predicate 匹配谓词 {@link Predicate}, 不能为 {@literal null}.
     * @return {@literal true} 如果存在匹配谓词 {@link Predicate} 的实体, 否则返回 {@literal false}
     */
    boolean existsByPredicate(Predicate predicate);

    /**
     * 与{@link #existsByPredicate(Predicate)}结果相反
     *
     * @param predicate 匹配谓词 {@link Predicate}, 不能为 {@literal null}.
     * @return {@literal true} 如果不存在匹配谓词 {@link Predicate} 的实体, 否则返回 {@literal false}
     */
    boolean notExistsByPredicate(final Predicate predicate);
}
