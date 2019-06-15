package cn.luotuoyulang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PersonMember {

    @RequestMapping(value = "/personList",method = RequestMethod.GET)
    public String personList(HttpServletRequest request){
//        int a = 1/0;
        System.err.println("===="+request.getSession().getId());
        return "member访问成功";
    }
}
