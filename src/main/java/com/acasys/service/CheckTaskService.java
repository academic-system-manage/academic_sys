package com.acasys.service;
import com.acasys.domain.Task;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CheckTaskService extends IService<Task> {
    List<Task> selectById(Integer courseid);
}
