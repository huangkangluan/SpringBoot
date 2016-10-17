package com.hzit.services;

import com.hzit.dao.entity.Grade;
import com.hzit.dao.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
@Service
public class GradeServices {
    @Autowired
    private GradeMapper gradeMapper;
    public List<Grade> findGrade(){
        return gradeMapper.searchGradeByParams(null);
    }
}
