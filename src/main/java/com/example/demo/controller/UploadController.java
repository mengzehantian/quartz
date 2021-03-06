package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @description: 文件上传
 * @author: halo
 * @create: 2019-12-04 17:29
 **/
@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D:/upload/quartz1/temp/";
        File dest = new File(filePath+fileName);
        try{
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功！";
        }catch (Exception e){
            LOGGER.error(e.toString(),e);
        }
        return "上传失败！";
    }
}
