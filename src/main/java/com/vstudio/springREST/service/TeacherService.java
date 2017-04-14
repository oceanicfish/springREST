package com.vstudio.springREST.service;

import com.vstudio.springREST.mapper.TeacherMapper;
import com.vstudio.springREST.model.Teacher;
import com.vstudio.springREST.util.ResponseData;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getAll() {
        List<Teacher> teachers = teacherMapper.selectTeachers();
        return teachers;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Teacher getTeacherByID(@PathVariable int id) {
        Teacher teacher = teacherMapper.selectTeacherByID(id);
        return teacher;
    }

    // to add new teacher POST
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addTeacher(@RequestBody Teacher teacher) {
        teacherMapper.addTeacher(teacher);
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);

        return responseData;
    }

    // to update teacher PUT
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseData updateTeacher(@RequestBody Teacher teacher) {

        teacherMapper.updateTeacher(teacher);

        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);

        return responseData;
    }

    //to delete teacher DELETE
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteTeacher(@PathVariable int id) {

        teacherMapper.deleteTeacher(id);

        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);

        return responseData;
    }

}
