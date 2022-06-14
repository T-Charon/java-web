package com.blb.controller;

import com.blb.entity.Student;
import com.blb.service.IClassService;
import com.blb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/

@Controller
public class StudentController {
    @Autowired
    private IClassService classService;

    @Autowired
    private IStudentService studentService;

    /**
     * 展示学生列表（获取所在班级id）
     * @param model
     * @param id
     * @return
     */
    @GetMapping("show_student/{id}")
    public String showStudent(Model model,@PathVariable int id){
        System.out.println(id);
        List<Student> studentList = studentService.list(id);
        model.addAttribute("studentList",studentList);
        System.out.println(studentList);
        return "student_info";
    }

    /**
     * 修改学生信息（获取学生id）
     * @param id
     * @param model
     * @return
     */
    @GetMapping("update_student/{id}")
    public String update(@PathVariable int id,Model model){
        List<Student> studentList = studentService.getById(id);
        System.out.println(studentList);
        model.addAttribute("updateStudentInfo",studentList);
        return "update_student";
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @ResponseBody
    @PostMapping("update_student")
    public String updateStudent(Student student){
        System.out.println(student);
        studentService.updateStudent(student);
        return "ok";
    }


    /**
     * 将班级ID回传
     * @param id
     * @param model
     * @return
     */
    @GetMapping("add_student/{id}")
    public String add(@PathVariable int id, Model model){
        System.out.println("classId为"+id);
        model.addAttribute("cId",id);
        return "add_student";
    }


    /**
     * 添加学生功能
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("add_student")
    public String addStudent(Student student){
        System.out.println("要添加的学生信息为"+student);
        studentService.addStudent(student);
        return "ok";
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("delete_student/{id}")
    public String delete(@PathVariable int id){
        System.out.println("要删除的id为"+id);
        studentService.deleteStudent(id);
        return "ok";
    }


}
