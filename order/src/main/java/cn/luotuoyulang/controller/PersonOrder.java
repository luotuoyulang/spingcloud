package cn.luotuoyulang.controller;

import cn.luotuoyulang.client.PersonMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonOrder {

    @Autowired
    PersonMemberService personMember;

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String personList(){
        String s = personMember.personList();
        return s;
    }
}
