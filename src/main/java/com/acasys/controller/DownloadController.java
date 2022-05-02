package com.acasys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/downloads")
public class DownloadController {
    private static final String DOWNLOAD_PATH = "C:/Java/";
    @GetMapping
    public String download(HttpServletResponse response, String requestFilename) {

        File file = new File(DOWNLOAD_PATH + requestFilename);
        if (!file.exists()) {
            return "所访问的资源不存在";
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            // 设置相关格式
            response.setContentType("application/force-download");
            // 设置下载后的文件名以及header
            response.addHeader("Content-disposition", "attachment;fileName=" + file.getName());
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024000];
            int len = 0;
            while((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "下载失败";
        }

        return "开始下载";
    }

}
