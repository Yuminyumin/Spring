package com.example.springweb.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.domain.BbsResponseDTO;
import com.example.springweb.test.mapper.BbsMapper;

@Service
public class BbsService {
    
    @Autowired
    private BbsMapper bbsMapper;

    public void save(BbsRequestDTO params){
        System.out.println("debug >>> service save() "+ bbsMapper);
        bbsMapper.saveRow(params);
    }

    public void update(BbsRequestDTO params){
        System.out.println("debug >>> service update() "+ bbsMapper);
        bbsMapper.updateRow(params);
    }

    public void delete(Map<String, Integer> map) {
        System.out.println("debug >>> service delete() "+ map.get("id"));
        bbsMapper.deleteRow(map);
    }

    public List<BbsResponseDTO> list() {
        System.out.println("debug >>> service list()");
        return bbsMapper.selectRow();
    }

    public BbsResponseDTO select(Map<String, Integer> map) {
        System.out.println("debug >>> service list()");
        return bbsMapper.getRow(map);
    }
}
