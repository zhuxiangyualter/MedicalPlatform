package com.medicalplatform.Utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * 分页工具类
 */
public class PageableUtils {
    /**
     * 默认页码
     */
    private static final int DEFAULT_PAGE = 1;
    /**
     * 默认每页大小
     */
    private static final int DEFAULT_SIZE = 20;

    private PageableUtils() {
    }

    /**
     * 从请求参数中提取分页数据并组装
     *
     * @param requestParams 请求参数
     * @return 分页实例
     */
    public static Pageable extract(Map<String, List<String>> requestParams) {
        final List<String> pageParams = requestParams.get("page");
        final List<String> sizeParams = requestParams.get("size");
        // 构建分页
        final int page;
        if (CollectionUtils.isNotBlank(pageParams)) {
            page = Integer.parseInt(pageParams.get(0));
        } else {
            page = DEFAULT_PAGE;
        }

        final int size;
        if (CollectionUtils.isNotBlank(sizeParams)) {
            size = Integer.parseInt(sizeParams.get(0));
        } else {
            size = DEFAULT_SIZE;
        }

        return PageRequest.of(page - 1, size);
    }

    /**
     * 组装Pageable
     *
     * @param page 页码
     * @param size 分页大小
     * @return 分页对象
     */
    public static Pageable extract(int page, int size) {
        if (page <= 0) {
            page = DEFAULT_PAGE;
        }

        if (size <= 0) {
            size = DEFAULT_SIZE;
        }

        return PageRequest.of(page - 1, size);
    }

}
