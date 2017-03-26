package com.vstudio.springREST.service;

import com.vstudio.springREST.mapper.TeacherMapper;
import com.vstudio.springREST.model.Teacher;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yang on 26/03/2017.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherService {

    private static SqlSessionFactory sessionFactory;
    private static ApplicationContext ctx;
    private static TeacherMapper teacherMapper;

    static {
        try {
            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
            teacherMapper = (TeacherMapper) ctx.getBean("teacherMapper");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "all", method = RequestMethod.GET, headers = "Accept=application/json", produces = {"application/json"})
    @ResponseBody
    public List<Teacher> getAll() {
        List<Teacher> teachers = teacherMapper.selectTeachers();
        return teachers;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = {"application/json"})
    @ResponseBody
    public Teacher getTeacherByID(@PathVariable int id) {
        Teacher teacher = teacherMapper.selectTeacherByID(id);
        return teacher;
    }

    // to add new teacher POST

    // to update teacher PUT

    //to delete teacher DELETE

}
