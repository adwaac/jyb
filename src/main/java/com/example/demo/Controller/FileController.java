package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.url}")
    private String path;

    @RequestMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile files[]) {
        log.trace("123");
        for (MultipartFile file : files) {
            String name = file.getOriginalFilename();
            File uploadfile = new File(path + "/" + name);
            if (!uploadfile.getParentFile().exists()) {
                try {
                    uploadfile.getParentFile().mkdirs();
                } catch (Exception e) {log.error("父文件夹创建");}
            }
            try {
                file.transferTo(uploadfile);
            } catch (IOException e) {
                log.error(e.getMessage());
                return "error";
            }
        }
        return "ok";
    }




    @RequestMapping("/download")
    public String fileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName){
        File file = new File(path +'/'+ fileName);
        if(!file.exists()){return "下载文件不存在";}
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            log.error("{}",e);
            return "下载失败";
        }
        return "下载成功";
    }
}
