package com.medicalplatform.Controller;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * 进行数据的导入
 */

import com.medicalplatform.Utils.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private static final String UPLOAD_DIR = "uploads";
    private final FileUtils fileUtils;

    public FileController(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    // 上传文件
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        // 处理文件上传逻辑
        // 例如，保存文件到本地或进行其他操作
        return "File uploaded successfully!";
    }
    //从url中获取文件
    @PostMapping("/download")
    public String downloadFile(@RequestParam("url") String url) {
        // 处理文件下载逻辑
        // 例如，从url下载文件到本地或进行其他操作
        return "File downloaded successfully!";
    }
    //从硬件中获取数据
    @PostMapping("/get")
    public String getFile(@RequestParam("url") String url) {
        // 处理文件下载逻辑
        // 例如，从url下载文件到本地或进行其他操作
        return "File downloaded successfully!";
    }





}
