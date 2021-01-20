package com.example.demo.service;

import com.example.demo.model.exception.PreCondition;
import com.example.demo.model.exception.VerifyException;
import com.example.demo.service.util.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @Author: Equator
 * @Date: 2021/1/20 20:52
 **/
@Slf4j
@Service
public class TestService {
    /**
     * 回音壁测试方法
     */
    public String ping(String req) {
        return String.format("current time %s, client send %s", new Date(), req);
    }

    /**
     * 保存文件并返回文件大小等信息
     */
    public String saveFile(MultipartFile file) {
        String sourceFileName = file.getOriginalFilename();
        log.info("上传的文件名称为：{}", sourceFileName);
        if (!sourceFileName.endsWith("jpg") && !sourceFileName.endsWith("png")) {
            throw new RuntimeException("不允许的文件格式");
        }
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(getUploadPath() + getRandomFileName(sourceFileName))))) {
            bos.write(file.getBytes());
            bos.flush();
        } catch (Exception e) {
            log.error("文件上传出错");
        }
        return String.format("上传的文件名为%s，文件大小为%s字节", sourceFileName, file.getSize());
    }

    /**
     * 获取随机生成的文件名
     */
    private String getRandomFileName(String sourceName) {
        PreCondition.isNotNull(sourceName);
        String suffix = sourceName.substring(sourceName.lastIndexOf("."));
        return IDUtil.getUUID() + suffix;
    }

    /**
     * 获取上传文件的相对路径
     */
    private String getUploadPath() {
        File classPath = null;
        try {
            classPath = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (classPath == null || !classPath.exists()) {
            classPath = new File("");
        }
        File path = new File(classPath.getAbsolutePath(), "static/upload/");
        if (!path.exists()) {
            path.mkdirs();
        }
        return path.getAbsolutePath() + File.separator;
    }
}
