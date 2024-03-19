package com.medicalplatform.Service.Basic;

import org.springframework.web.multipart.MultipartFile;


/**
 * Description:
 * 可导入数据的 Service 接口
 *
 * @author am
 */
public interface ImportableService {
    /**
     * 导入数据
     *
     * @param eventKey 异步事件 key
     * @param file     导入的文件
     */
    void importData(final String eventKey, final MultipartFile file);
}
