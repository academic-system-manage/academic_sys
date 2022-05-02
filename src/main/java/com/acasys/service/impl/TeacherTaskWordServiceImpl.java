package com.edusystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edusystem.Dao.TeacherTaskWordDao;
import com.edusystem.Domain.Task;
import com.edusystem.Service.TeacherTaskWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherTaskWordServiceImpl extends ServiceImpl<TeacherTaskWordDao,Task> implements TeacherTaskWordService {
}
