package com.example.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.domain.BbsResponseDTO;
import com.example.springweb.test.mapper.BbsMapper;
import java.util.List;

@SpringBootTest
public class MybatisApplicationTests {
    
    @Autowired
    private BbsMapper bbsMapper;

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>>>>>" + bbsMapper);
        BbsRequestDTO request = BbsRequestDTO.builder()
                                    .title("겁나 어렵다")
                                    .content("뻥이 아니야 어려워")
                                    .build();

        bbsMapper.saveRow(request);
        System.out.println("debug >>>> save success!!!!");;
    }

    @Test
    public void selectTest(){
        System.out.println("debug mapper >>>>>>>" + bbsMapper);
        List<BbsResponseDTO> list = bbsMapper.selectRow();
        for(BbsResponseDTO dto : list) {
            System.out.println(dto);
        }
    }
}
