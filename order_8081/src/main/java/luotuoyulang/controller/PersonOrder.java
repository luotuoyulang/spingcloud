package luotuoyulang.controller;

import luotuoyulang.client.PersonMemberService;
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

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String personList(){
        String s = personMember.personList();
        return s;
    }

    @RequestMapping(value = "/b",method = RequestMethod.GET)
    public HashMap<String,String> b(HttpServletRequest request){
        String id = request.getSession().getId();
        HashMap<String, String> map = new HashMap<>();
        map.put("port","8081");
        map.put("sessionid",id);
        return map;
    }
}
