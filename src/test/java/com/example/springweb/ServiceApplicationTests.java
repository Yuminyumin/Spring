package com.example.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.service.BbsService;
import java.util.Map;
import java.util.HashMap;

@SpringBootTest
public class ServiceApplicationTests {

    @Autowired
    private BbsService bbbService;
    
    @Test
    public void saveService(){
        System.out.println("debug >>>> junit service save : " + bbbService);
        BbsRequestDTO request = BbsRequestDTO.builder()
                                    .title("오늘은 쉽다")
                                    .content("진짜 이렇게 간단한거였어!!")
                                    .build();
        bbbService.save(request);
        System.out.println("debug >>> save OK!! ");
    }
    /*
    테이블에 있는 기본키 값으로 title, content 수정하고 싶다.
    1. BbsRequestDTO 타입으로 더미데이터를 생성하고
    2. bbsService.update(); 메서드의 인자로 전달
    3. update() 메서드에서 mapper의 updateRow() 정의하고 BbsRequestDTO 전달하고
    4. BbsMapper.xml에 update 태그를 추가해서
    수정이 구현되도록 실습

    */
    @Test
    public void updateService() {
        System.out.println("debug >>>> junit service update : " + bbbService);
        BbsRequestDTO request = BbsRequestDTO.builder()
                                    .id(1)
                                    .title("update한 제목")
                                    .content("update해써요 ")
                                    .build();                            
        bbbService.update(request);
        System.out.println("debug >>> junit service update OK!!!");
    }

}
