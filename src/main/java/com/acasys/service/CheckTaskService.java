package com.edusystem.Service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edusystem.Domain.Task;

import java.util.List;

public interface CheckTaskService extends IService<Task> {
    List<Task> selectById(Integer courseid);
}
