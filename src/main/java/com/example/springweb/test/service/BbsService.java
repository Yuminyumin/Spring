package com.example.springweb.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.mapper.BbsMapper;
import java.util.Map;

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
}
