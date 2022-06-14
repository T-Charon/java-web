package com.blb.controller;

import com.blb.entity.Class;
import com.blb.entity.Student;
import com.blb.service.IClassService;
import com.blb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.awt.SystemColor.info;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/

@Controller
public class ClassController {

    @Autowired
    private IClassService classService;

    @Autowired
    private IStudentService studentService;

    /**
     * 在后台查询list信息传到前台，显示班级首页
     * @param model
     * @return
     */
    @GetMapping ("")
    public String list(Model model){
        List<Class> list = classService.list();
        model.addAttribute("list",list);
        return "index";
    }


    /**
     * 从前台获取要更新的班级名称，并跳转更新的JSP页面
     * @param name
     * @param model
     * @return
     */
    @GetMapping ("update_class/{name}")
    public String update_class(@PathVariable String name,Model model){
        System.out.println("要更新的classname为"+name);
        List<Class> classList = classService.getByName(name);
        model.addAttribute("class_id",classList.get(0).getId());
        model.addAttribute("cName",classList.get(0).getClassName());
        return "update_class";
    }

    /**
     * 在后台根据要修改的班级信息传到前台
     * @param c
     * @return
     */
    @ResponseBody
    @PostMapping("update_class")
    public String updateClass(Class c){
        System.out.println(c);
        List<Class> list = classService.getByName(c.getClassName());
        if(list.size() == 0){
            classService.updateClass(c);
            return "ok";
        }else {
            return "0";
        }

    }

    /**
     * 从前台获取要删除的班级ID
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("delete_class/{id}")
    public String deleteClass(@PathVariable Integer id){
        System.out.println("要删除的班级Id为"+id);
        List<Student> list = studentService.getByCId(id);
        if(list.size() == 0){
            classService.deleteClass(id);
            return "ok";
        }else {
            return "0";
        }

    }

}
