package com.rain.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/22 1:25
 */
public class UploadUtil {
    public String fileUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
//获取文件名称
        String fileNameOne = file.getOriginalFilename();
        //文件长度
        int size = (int) file.getSize();
        System.out.println(fileNameOne + "-->" + size);
        //获取文件后缀名称
        String suffixName = fileNameOne.substring(fileNameOne.lastIndexOf("."));
        System.out.println("后缀名为：" + suffixName);
        //文件上传的路径
        String filePath = "D:\\springboot-super\\src\\main\\resources\\static\\image\\";
        String fileRelativePath = "image/";
        //解决中文问题可以加uuid
        fileNameOne = UUID.randomUUID() + suffixName;
        File files = new File(filePath + fileNameOne);
        //检测目录是否存在
        if (!files.getParentFile().exists()) {
            files.getParentFile().mkdirs();
        }
        try {
            file.transferTo(files);
            return fileRelativePath+fileNameOne;

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
