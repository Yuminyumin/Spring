package com.example.springweb.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.domain.BbsResponseDTO;

import java.util.List;
/*
bbs_tbl 과 CRUD 작업을 위한 추상 메서드 선언
Mapper는 기존 Dao와 동일한 작업 수행하는 역할
 */
@Mapper
public interface BbsMapper {

    public void saveRow(BbsRequestDTO params);

    public List<BbsResponseDTO> selectRow();

    public BbsResponseDTO getRow(BbsRequestDTO params);
}
