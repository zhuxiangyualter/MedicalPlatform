package com.medicalplatform.Service.Basic;


import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Description:
 *
 * @author am
 */
public interface ExportService {

    Logger log = LoggerFactory.getLogger(ExportService.class);

    /**
     * 导出
     *
     * @param token        导出token
     * @param queryParams  请求参数
     * @param exportFields 导出字段
     */
    default void export(String token, MultiValueMap<String, String> queryParams, List<String> exportFields) {
    }

    /**
     * 导出 默认导出全部字段
     *
     * @param token       异步导出 token
     * @param queryParams 请求参数
     */
    default void export(String token, MultiValueMap<String, String> queryParams) {
        export(token, queryParams, ImmutableList.of());
    }

    /**
     * 同步导出方法
     *
     * @param requestParam 请求参数
     * @param exportFields 导出字段
     * @return
     */
    default ResponseEntity<byte[]> exportSync(MultiValueMap<String, String> requestParam, List<String> exportFields) {
        log.error("同步导出方法未实现！！！");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 同步导出方法
     *
     * @param requestParam 请求参数
     */
    default ResponseEntity<byte[]> exportSync(MultiValueMap<String, String> requestParam) {
        log.error("同步导出方法未实现！！！");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
