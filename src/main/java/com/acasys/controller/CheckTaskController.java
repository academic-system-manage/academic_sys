package com.acasys.controller;


import com.acasys.controller.Utils.R;
import com.acasys.service.CheckTaskService;
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
