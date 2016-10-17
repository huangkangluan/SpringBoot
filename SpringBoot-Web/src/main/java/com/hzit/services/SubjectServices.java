package com.hzit.services;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.hzit.dao.entity.Grade;
import com.hzit.dao.entity.Subject;
import com.hzit.dao.mapper.GradeMapper;
import com.hzit.dao.mapper.SubjectMapper;
import com.hzit.dao.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/27.
 */
@Service
public class SubjectServices {
    public SubjectServices(){
        System.out.println("业务逻辑对象被创建");
    }
    @Autowired
    private SubjectMapper subjectMapper;

    public List<SubjectVo> findAll(){
        System.out.println("业务逻辑类，依赖了"+subjectMapper+"数据访问类");
        return subjectMapper.searchSubjectByParams(null);
    }
    public Page<SubjectVo> findPage(int page,int count){
        PageRequest pageRequest=new PageRequest(page,count);
        Page<SubjectVo> data=subjectMapper.searchSubjectByParams(null, pageRequest);
        return data;
    }
    public boolean addSubject(Subject subject){
        try{

            subjectMapper.insertSubject(subject);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
       return false;
    }
    public int deleteSubject(int subjectNo){
        int num=subjectMapper.deleteSubjectBySubjectNo(subjectNo);
        return num;
    }
    public SubjectVo findBySubjectNo(int subjectNo){
        Map map=new HashMap();
        map.put("subjectNo",subjectNo);
        List<SubjectVo> list=subjectMapper.searchSubjectByParams(map);
        if (list.size()==1){
            return list.get(0);
        }else {
            return null;
        }
    }
    public int updateSubject(Subject subject){
        return subjectMapper.updateSubject(subject);
    }
}
