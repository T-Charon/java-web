package com.blb.day_20220625_springboot.controller;


import com.blb.day_20220625_springboot.entity.Person;
import com.blb.day_20220625_springboot.service.IPersonService;
import com.blb.day_20220625_springboot.utils.ResposeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * @Author Charon
 * @Date 2022/6/23
 **/

@Api
@CrossOrigin    //允许跨域注解
@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    @ApiOperation("查询数据")
    @GetMapping("list")
    public ResposeResult<List<Person>> getPersonPage(){

        List<Person> persons = personService.list(null);
        return ResposeResult.ok(persons);
    }


//    /**
//     * 分页查询所有person信息
//     * @return
//     */
//    @ApiOperation("分页查询数据")
//    @GetMapping("limit/{current}")
//    public ResposeResult<List<Person>> getPersonPage(@PathVariable Long current){
//        //判断当前页数是否为第一页
//        if(current < 1){
//            current = 1L;
//        }
//        IPage<Person> page = personService.getPage(current, 2L);
//        List<Person> personList = page.getRecords();
//        //总页数
//        Long totalPage = (long) Math.ceil(page.getTotal()/2L);
//        //将总页数放入person集合
//        for (Person p : personList) {
//            p.setPage(totalPage);
//        }
//        return ResposeResult.ok(personList);
//    }


    @ApiOperation("新增人员信息")
    @PostMapping("person")
    public ResposeResult<String> addPerson(Person person){
        System.out.println(person);
        //保存person信息
        personService.save(person);
        return ResposeResult.ok("ok");
    }

    @ApiOperation("修改人员信息")
    @PutMapping ("person")
    public ResposeResult<String> updatePerson(@RequestBody Person person){

        personService.updateById(person);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("删除人员信息")
    @DeleteMapping("person/{id}")
    public ResposeResult<String> deletePerson(@PathVariable int id){
        personService.removeById(id);
        return ResposeResult.ok("ok");
    }



}
