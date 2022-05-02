package com.acasys.controller;


import com.acasys.controller.Utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/studentstasks")
public class StudentSubmit {
    @PostMapping
    public R save(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            return new R(false,"文件为空，请选择文件后再上传");
        }
        //获得上传文件的名称
        String originName=file.getOriginalFilename();
        //获取后缀名
        assert originName != null;
        String suffix = originName.substring(originName.lastIndexOf("."));
        //将上传的文件保存至本地磁盘
        file.transferTo(new File("D:\\test\\"+originName));
        return new R(true,"上传成功！");
    }

}
