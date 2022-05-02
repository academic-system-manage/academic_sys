package com.acasys.service.impl;

import com.acasys.domain.Task;
import com.acasys.mapper.TeacherTaskWordDao;
import com.acasys.service.TeacherTaskWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TeacherTaskWordServiceImpl extends ServiceImpl<TeacherTaskWordDao, Task> implements TeacherTaskWordService {
}
