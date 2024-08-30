package com.example.springweb.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.domain.BbsResponseDTO;
import com.example.springweb.test.domain.comment.CommentResponseDTO;
import com.example.springweb.test.domain.comment.CommentRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/*
bbs_tbl 과 CRUD 작업을 위한 추상 메서드 선언
Mapper는 기존 Dao와 동일한 작업 수행하는 역할
 */
@Mapper
public interface BbsMapper {

    public void saveRow(BbsRequestDTO params);

    public List<BbsResponseDTO> selectRow();

    public Optional<BbsResponseDTO> getRow(Map<String, Integer>map);

    public void deleteRow(Map<String, Integer> map);

    public void updateRow(BbsRequestDTO params);

    ///////// comment
    public void commentSaveRow(CommentRequestDTO params);
    public ArrayList<CommentResponseDTO> commentSelectRow(Map<String, Integer> map);
}
