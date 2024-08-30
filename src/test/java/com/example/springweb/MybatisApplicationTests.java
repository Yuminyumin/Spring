package com.example.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.domain.BbsResponseDTO;
import com.example.springweb.test.mapper.BbsMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
@SpringBootTest
public class MybatisApplicationTests {
    
    @Autowired
    private BbsMapper bbsMapper;

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>>>>>" + bbsMapper);
        // BbsRequestDTO request = BbsRequestDTO.builder()
        //                             .title("겁나 어렵다")
        //                             .content("뻥이 아니야 어려워")
        //                             .build();

        // bbsMapper.saveRow(request);
        // System.out.println("debug >>>> save success!!!!");;
    }

    @Test
    public void selectTest(){
        System.out.println("debug mapper >>>>>>>" + bbsMapper);
        List<BbsResponseDTO> list = bbsMapper.selectRow();
        for(BbsResponseDTO dto : list) {
            System.out.println(dto);
        }
    }
    @Test
    public void selectOne(){
        System.out.println("debug mapper >>>> "+ bbsMapper);
        Map<String, Integer>map = new HashMap<>();
        map.put("id",2);
        Optional<BbsResponseDTO> response = bbsMapper.getRow(map);
        System.out.println("debug >>> select One "+ response);
    }

    @Test
    public void deleteTest(){
        System.out.println("debug mapper >>>> "+ bbsMapper);
        Map<String, Integer>map = new HashMap<>();
        map.put("id",2);
        bbsMapper.deleteRow(map);
        System.out.println("debug >>> delete Ok!!");
    }
}
