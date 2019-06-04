package luotuoyulang.client;


import org.springframework.stereotype.Service;

@Service
public class PersonMemberHystrix implements PersonMemberService{


    @Override
    public String personList() {
        return "500 !!!!";
    }
}