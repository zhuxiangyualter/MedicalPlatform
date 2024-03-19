package com.medicalplatform.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
public class FileUtils {
    private static final String UPLOAD_DIR = "uploads";

    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            // 生成新的文件名
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            String newFileName = file.getContentType() + extension;

            // 设置上传目录路径
            Path uploadDir = Paths.get(UPLOAD_DIR);
            // 创建上传目录（如果不存在）
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            // 设置上传文件路径
            Path filePath = uploadDir.resolve(newFileName);
            // 将文件保存到指定目录
            Files.copy(file.getInputStream(), filePath);
            // 返回上传成功的消息
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + newFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
    /**
     * 判断文件是否是excel
     *
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        if (!(file.isFile() && (file.getName().endsWith("xls") || file.getName().endsWith("xlsx")))) {
            throw new Exception("文件不是Excel");
        }
    }
}
