package com.edusystem.Controller;

import com.edusystem.Controller.Utils.R;
import com.edusystem.Domain.Task;
import com.edusystem.Service.TeacherTaskWordService;
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
