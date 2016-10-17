import com.fc.platform.commons.page.Page;
import com.hzit.StartWebApp;
import com.hzit.dao.entity.Grade;
import com.hzit.dao.entity.Subject;
import com.hzit.dao.vo.SubjectVo;
import com.hzit.services.GradeServices;
import com.hzit.services.SubjectServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = StartWebApp.class)
public class Test_Subject {

    @Autowired
    private SubjectServices subjectServices;
    @Autowired
    private GradeServices gradeServices;
    @Test
    public void testOne(){
        List<SubjectVo> list=subjectServices.findAll();
        for (SubjectVo s:list){
            System.out.println(s.getSubjectName());
        }
    }
    @Test
    public void testTwo(){
        Page<SubjectVo> page=subjectServices.findPage(0,3);
        List<SubjectVo> list=page.getContent();
        for (SubjectVo s:list){
            System.out.println(s.getSubjectName());
        }
        System.out.println("总共有"+page.getTotalElements()+"行数");
        System.out.println("总共有"+page.getTotalPages()+"页数");
    }
    @Test
    public void testthree(){
        short a=1;
        Integer b=1;
        if(a==b){
            System.out.println(a==b);
        }
    }
    @Test
    public void deletesubject(){
        int num=subjectServices.deleteSubject(191);
        System.out.println(num);
    }
    @Test
    public void findBySubjectNo(){
        SubjectVo subject=subjectServices.findBySubjectNo(2);
        System.out.println(subject.getSubjectName());
    }
    @Test
    public void findGrade(){
        List<Grade> list=gradeServices.findGrade();
        for (Grade g:list){
            System.out.println(g.getGradeName());
        }
    }

}
