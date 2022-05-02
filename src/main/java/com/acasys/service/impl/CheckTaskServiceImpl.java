package com.acasys.service.impl;

import com.acasys.domain.Task;
import com.acasys.mapper.CheckTaskDao;
import com.acasys.service.CheckTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckTaskServiceImpl extends ServiceImpl<CheckTaskDao, Task> implements CheckTaskService {
    @Autowired
    private CheckTaskDao checkTaskDao;
    @Override
    public List<Task> selectById(Integer courseid) {
        return checkTaskDao.selectByCourseid(courseid);
    }
}
