package com.edusystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edusystem.Dao.CheckTaskDao;
import com.edusystem.Dao.TeacherTaskWordDao;
import com.edusystem.Domain.Task;
import com.edusystem.Service.CheckTaskService;
import com.edusystem.Service.TeacherTaskWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckTaskServiceImpl extends ServiceImpl<CheckTaskDao,Task> implements CheckTaskService {
    @Autowired
    private CheckTaskDao checkTaskDao;
    @Override
    public List<Task> selectById(Integer courseid) {
        return checkTaskDao.selectByCourseid(courseid);
    }
}
