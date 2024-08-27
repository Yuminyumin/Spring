package com.example.springweb.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
//spring container는 TestController testController = new TestController();
public class TestController {

    //어노테이션 @RequestMapping > 메소드의 기능을 사용자리퀘스트 패스와 매핑을 통해 연결시킴
    @RequestMapping("/index.kdt") //객체 생성
    public String index(Model model) {
        System.out.println("debug >>> test controller indx client path : /index.kdt");

        //model에 심는 건 request 심는 것과 같은 역할
        model.addAttribute("msg","처음으로 만나는 스프링부트");
        
        return "index";
    }
    
}
