package cn.luotuoyulang.controller;

import cn.luotuoyulang.client.PersonMemberService;
import cn.luotuoyulang.entity.Cat;
import cn.luotuoyulang.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class PersonOrder {

    @Autowired
    PersonMemberService personMember;

//    @Autowired
//    RedisUtil redisUtil;

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String personList(HttpServletRequest request){
        String s = personMember.personList();
        System.err.println("===="+request.getSession().getId());
        return s;
    }

    @RequestMapping(value = "/b",method = RequestMethod.GET)
    public HashMap<String,String> b(HttpServletRequest request){
        String id = request.getSession().getId();
        HashMap<String, String> map = new HashMap<>();
        map.put("port","8080");
        map.put("sessionid",id);
        return map;
    }

    @RequestMapping(value = "/c",method = RequestMethod.GET)
    public HashMap<String,String> c(HttpServletRequest request){
        request.getSession().invalidate();
        String id = request.getSession().getId();
        HashMap<String, String> map = new HashMap<>();
        map.put("port","8080");
        map.put("sessionid",id);
        return map;
    }

    @RequestMapping(value = "/d",method = RequestMethod.GET)
    public Cat d(){
        Cat cat = new Cat();
        cat.setColor("红色");
        cat.setName("小花");
//        redisUtil.set("xiaoliu",cat);
//
//        Object xiaoliu = redisUtil.get("xiaoliu");
//        System.out.println(xiaoliu);
        return cat;
    }
}
