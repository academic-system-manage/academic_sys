package com.acasys.service.impl;

import com.acasys.domain.CourseSelect;
import com.acasys.domain.DetailMark;
import com.acasys.domain.Task;
import com.acasys.mapper.CheckTaskDao;
import com.acasys.mapper.CourseSelectMapper;
import com.acasys.mapper.DetailMarkMapper;
import com.acasys.service.GradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private CourseSelectMapper courseSelectMapper;

    @Autowired
    private DetailMarkMapper detailMarkMapper;

    @Autowired
    private CheckTaskDao checkTaskDao;

    /**
     * 查询某个学生所有课程总成绩
     * @param studentid
     * @return
     */
    @Override
    public List<CourseSelect> getCourseGrade(Integer studentid) {
        QueryWrapper<CourseSelect> qw= new QueryWrapper<>();
        qw.eq("studentid",studentid);
        List<CourseSelect> list = courseSelectMapper.selectList(qw);
        return list;
    }

    @Override
    public List<DetailMark> getDetailGrade(Integer studentid, Integer courseid) {
        List<DetailMark> detailMarkList = detailMarkMapper.getAll(studentid,courseid);
        if(detailMarkList==null)return null;
        for (DetailMark detailMark : detailMarkList) {
            QueryWrapper<Task> qw= new QueryWrapper<>();
            qw.eq("idtask",detailMark.getTask().getIdtask());
            Task task = checkTaskDao.selectOne(qw);
            detailMark.setTask(task);
        }
        return detailMarkList;
    }
}
