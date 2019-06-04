package cn.luotuoyulang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonMember {

    @RequestMapping(value = "/personList",method = RequestMethod.GET)
    public String personList(){
//        int a = 1/0;
        return "member访问成功";
    }
}
