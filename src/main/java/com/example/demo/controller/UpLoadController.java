package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class UpLoadController {
    @PostMapping(value="/upload" )
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String  description,
                         @RequestParam("file") MultipartFile file) throws Exception{
        //接收参数description
        System.out.println("description: " + description);
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/upload/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filePath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path+File.separator + filename));
            System.out.println(path+filename);
            return path+filename;
        }else {
            return "error";
        }
    }
}
