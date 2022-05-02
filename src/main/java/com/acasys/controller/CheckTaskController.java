package com.edusystem.Controller;

import com.edusystem.Controller.Utils.R;
import com.edusystem.Domain.Task;
import com.edusystem.Service.CheckTaskService;
import com.edusystem.Service.TeacherTaskWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checktasks")
public class CheckTaskController {
    @Autowired
    private CheckTaskService taskService;
    @GetMapping("{courseid}")
    public R selectById(@PathVariable Integer courseid){
        return new R(true,taskService.selectById(courseid));
    }

}
