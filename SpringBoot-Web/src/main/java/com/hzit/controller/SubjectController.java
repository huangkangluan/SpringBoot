package com.hzit.controller;

import com.fc.platform.commons.page.Page;
import com.hzit.dao.entity.Grade;
import com.hzit.dao.entity.Subject;
import com.hzit.dao.vo.SubjectVo;
import com.hzit.services.GradeServices;
import com.hzit.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
public class SubjectController {
    public SubjectController(){
        System.out.println("SubjectController控制器对象被创建");
    }
    @Autowired
    private SubjectServices subjectServices;
    @Autowired
    private GradeServices gradeServices;
    @RequestMapping("/subject")
     @ResponseBody
     public Object getSubject(){
        return subjectServices.findAll();
    }
    @RequestMapping("/show")
    public String findSubject(@RequestParam(name="page",defaultValue = "0") Integer page, ModelMap modelMap){
        if(page<=0){
            page=0;
        }
        Page<SubjectVo> list=subjectServices.findPage(page,5);
        modelMap.put("list",list);
        modelMap.put("countpage",page);
        return "home";
    }
    @RequestMapping("/addSubject")
    @ResponseBody
    public boolean addSubject(Subject subject, ModelMap modelMap){
        boolean boo=subjectServices.addSubject(subject);
        return boo;
        }
    @RequestMapping("/toaddSubject")
    public String toaddSubject(ModelMap modelMap){
        List<Grade> glist=gradeServices.findGrade();
        modelMap.put("glist",glist);
        return "addsub";
    }
    @RequestMapping("/deletSubject")
    @ResponseBody
    public int deleteSubject(@RequestParam("subjectNo")Integer subjectNo){
        try{
            int num=subjectServices.deleteSubject(subjectNo);
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    @RequestMapping("/toupdateSubject")
    public String findBySuject(@RequestParam("subjectNo")Integer subjectNo,ModelMap modelMap){
        try{
            SubjectVo subject=subjectServices.findBySubjectNo(subjectNo);
            List<Grade> glist=gradeServices.findGrade();
            modelMap.put("glist",glist);
            modelMap.put("subjectVo",subject);
            return "updatesub";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
    @RequestMapping("/doupdateSubject")
    @ResponseBody
    public int updateSubject(Subject subject){
        int num=subjectServices.updateSubject(subject);
        return num;
    }
}

