package com.vstudio.springREST.mapper;

import com.vstudio.springREST.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yang on 22/03/2017.
 */

public interface TeacherMapper {

    @Autowired
    public Teacher selectTeacherByID(int id);
    @Autowired
    public List<Teacher> selectTeachers();
    @Autowired
    public void addTeacher(Teacher teacher);
}
