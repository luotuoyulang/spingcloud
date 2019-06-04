package cn.luotuoyulang.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "member" ,fallback = PersonMemberHystrix.class)
//@FeignClient(value = "member")
public interface PersonMemberService {
    @RequestMapping(value = "/personList",method = RequestMethod.GET)
    String personList();
}