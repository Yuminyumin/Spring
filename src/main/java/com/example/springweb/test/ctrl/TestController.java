package com.example.springweb.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springweb.test.domain.BbsResponseDTO;


@Controller
//spring container는 TestController testController = new TestController();
public class TestController {

    //분기방식
    //어노테이션 @RequestMapping > 메소드의 기능을 사용자리퀘스트 패스와 매핑을 통해 연결시킴
    @RequestMapping("/index.kdt") //객체 생성
    public String index(Model model) {
        System.out.println("debug >>> test controller indx client path : /index.kdt");

        //model에 심는 건 request 심는 것과 같은 역할
        model.addAttribute("msg","처음으로 만나는 스프링부트");
        
        return "index";
    }
    //비동기 방식
    @RequestMapping("/api/bbs/ctrl/test")
    @ResponseBody//json화 시켜주는 어노테이션
    public  BbsResponseDTO test() {
        BbsResponseDTO response = BbsResponseDTO.builder()
                                    .id(1)
                                    .title("test")
                                    .content("test")
                                    .build();
        return response;
    }
    
}
