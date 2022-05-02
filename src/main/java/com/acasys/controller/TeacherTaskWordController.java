package com.acasys.controller;

import com.acasys.controller.Utils.R;
import com.acasys.domain.Task;
import com.acasys.service.TeacherTaskWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachertaskinwords")
public class TeacherTaskWordController {
    @Autowired
    private TeacherTaskWordService taskWordService;
    @PostMapping
    public R save(@RequestBody Task task){
        return new R(taskWordService.save(task));
    }

}
