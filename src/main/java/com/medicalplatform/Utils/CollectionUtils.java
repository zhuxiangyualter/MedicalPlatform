package com.medicalplatform.Utils;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Stream;

/**
 * Description:
 * 集合工具类
 *
 * @author am
 */
@SuppressWarnings({"unchecked", "unused", "WeakerAccess"})
public class CollectionUtils {

    private CollectionUtils() {
    }

    /**
     * 将{@link Iterable} 转换成 {@link Stream}
     *
     * @param iterable 转被转换的iterable
     * @return Stream
     */
    public static <T> Stream<T> toStream(Iterable<T> iterable) {
        final Stream.Builder<T> builder = Stream.builder();
        iterable.forEach(builder::add);
        return builder.build();
    }

    /**
     * 将 {@code Map<K, List<V>>} 转换成 {@code MultiValueMap<K, V>}
     *
     * @param listMap {@code Map<K, List<V>>}
     * @return {@code MultiValueMap<K, V>}
     */
    public static <K, V> MultiValueMap<K, V> convertListMapToMultiValueMap(Map<K, List<V>> listMap) {
        if(listMap == null){
            return null;
        }
        MultiValueMap<K, V> target = new LinkedMultiValueMap<>();
        target.putAll(listMap);
        return target;
    }

    public static <E> boolean elementNotEquals(final Collection<E> a, final Collection<E> b) {
        return !elementEquals(a, b);
    }

    /**
     * 比较两个集合中的元素是否相等
     *
     * @param a 集合a
     * @param b 集合b
     * @return 如果相等则返回 {@literal true}, 否则返回 {@literal false}
     */
    public static <E> boolean elementEquals(final Collection<E> a, final Collection<E> b) {
        List<E> aCopy = Lists.newArrayList(a);
        List<E> bCopy = Lists.newArrayList(b);

        final boolean aChanged = aCopy.removeAll(b);
        final boolean bChanged = bCopy.removeAll(a);
        if (aChanged && bChanged) {
            return aCopy.isEmpty() && bCopy.isEmpty();
        } else {
            return false;
        }

    }

    /**
     * list分页
     *
     * @param source 要分页的list
     * @param page   页码 从0开始
     * @param size   页大小
     * @return 分页后的list
     */
    public static <T> List<T> pageList(List<T> source, int page, int size) {
        final int listSize = source.size();
        final int offset = page * size;
        if (page < 0 || size < 1) {
            return source.subList(0, 0);
        } else {
            if (listSize >= offset + size) {
                return source.subList(offset, offset + size);
            } else {
                return source.subList(offset, listSize);
            }
        }
    }

    /**
     * 从集合中随机提取一个元素
     *
     * @param source 集合
     * @return 随机元素
     */
    public static <T> T randomTake(Collection<? extends T> source) {
        final int size = source.size();
        final int randomPos = RandomUtil.randomInt(size);
        final Iterator<? extends T> iterator = source.iterator();
        int count = 0;
        while (count < randomPos) {
            count++;
            iterator.next();
        }
        return iterator.next();
    }

    /**
     * 向一个可能为空的 {@link List<T>} 中添加一个元素
     * <p>
     * 如果 {@code List} 不为空, 则直接添加
     * 否则将创建一个新的 {@code List}
     * </p>
     *
     * @param nullableList 可能为空的 {@code List}
     * @param items        待添加的元素
     * @return 返回添加元素后的 {@code List}
     */
    public static <T> List<T> addToNullableList(List<T> nullableList, T... items) {

        if (items == null) {
            throw new IllegalArgumentException("item can not be null");
        }

        if (isNotBlank(nullableList)) {
            nullableList.addAll(Arrays.asList(items));
            return nullableList;
        } else {
            return Lists.newArrayList(items);
        }
    }

    /**
     * 集合判断非空
     * <p>
     * {@literal null} or {@code empty} 均为空
     * </p>
     *
     * @param collection 集合
     * @return 是否为非空
     */
    public static boolean isNotBlank(Collection<?> collection) {
        return !isBlank(collection);
    }

    /**
     * 集合判断空
     * <p>
     * {@literal null} or {@code empty}均为空
     * </p>
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isBlank(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 向一个可能为空的 {@link Set<T>} 中添加一个元素
     * <p>
     * 如果 {@code Set} 不为空, 则直接添加
     * 否则将创建一个新的 {@code Set}
     * </p>
     *
     * @param nullableSet 可能为空的 {@code Set}
     * @param items       待添加的元素
     * @return 返回添加元素后的 {@code Set}
     */
    public static <T> Set<T> addToNullableSet(Set<T> nullableSet, T... items) {

        if (items == null) {
            throw new IllegalArgumentException("item can not be null");
        }

        if (isNotBlank(nullableSet)) {
            nullableSet.addAll(Arrays.asList(items));
            return nullableSet;
        } else {
            return Sets.newHashSet(items);
        }
    }

    /**
     * 从一个可能为空的 {@link Set<T>} 中删除一个元素
     * <p>
     * 如果 {@code Set} 不为空, 则直接添加
     * 否则将创建一个新的 {@code Set}
     * </p>
     *
     * @param nullableSet 可能为空的 {@code Set}
     * @param items       待添加的元素
     * @return 返回添加元素后的 {@code Set}
     */
    public static <T> Set<T> removeFromNullableSet(Set<T> nullableSet, T... items) {

        if (items == null) {
            throw new IllegalArgumentException("item can not be null");
        }

        if (isNotBlank(nullableSet)) {
            nullableSet.removeAll(Arrays.asList(items));
            return nullableSet;
        } else {
            return Sets.newHashSet();
        }
    }

    /**
     * 从set中查找一个元素
     *
     * @param set       被查找的set
     * @param something 元素
     * @return 如果找到则返回原本元素，否则返回null
     */
    public static <T> T findBySet(Set<T> set, T something) {
        if (something == null) {
            return null;
        }
        for (final T t : set) {
            if (Objects.equals(t, something)) {
                return something;
            }
        }
        return null;
    }
}
