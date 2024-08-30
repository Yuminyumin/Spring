package com.example.springweb.test.ctrl;

import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springweb.test.domain.BbsRequestDTO;
import com.example.springweb.test.domain.BbsResponseDTO;
import com.example.springweb.test.domain.comment.CommentRequestDTO;
import com.example.springweb.test.service.BbsService;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
// user : http://localhost:7777/api/bbs
@RequestMapping("api/bbs")
public class BbsController {
    
    @Autowired
    private BbsService bbsService;

    // user : http://localhost:7777/api/bbs/test
    @GetMapping("/test")
    public ResponseEntity<BbsResponseDTO> test() {
        // BbsResponseDTO response = BbsResponseDTO.builder()
        //                             .id(1)
        //                             .title("test")
        //                             .content("test")
        //                             .build();
        // return new ResponseEntity<>(response, HttpStatus.OK);
        return null;
    }

    /*
     * 파라미터로 전달되는 id에 해당되는 데이터를 삭제한다면?
     * service - mapper 연동을 통한 삭제 구현
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path /delete");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        bbsService.delete(map);
        
        return new ResponseEntity<String>(id+" 번째 데이터 삭제 ", HttpStatus.OK);
    }

    /*
    Bbs 목록 조회
    */
    @GetMapping("/list")
    public ResponseEntity<List<BbsResponseDTO>> getList() {
        System.out.println("debug >>> bbs controller client path /list");
        List<BbsResponseDTO> list = bbsService.list();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    /*
    Bbs 데이터 조회
    */
    @GetMapping("/view/{id}")
    public ResponseEntity<Object> view(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path /view");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        Optional<BbsResponseDTO> response = bbsService.select(map);
        if(response.isPresent()){
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("에러 발생", HttpStatus.OK);
        }
        
        
    }

    /*
    Bbs 새 글을 작성
    user endpoint http://localhost:7777/api/bbs/post?title=xxxx&content=xxxx
    */
    // @PostMapping("/post")
    // public ResponseEntity<String> save(@RequestParam("title")   String title,
    //                                    @RequestParam("content") String content) {
    //     BbsRequestDTO params = BbsRequestDTO.builder()
    //                                         .title(title)
    //                                         .content(content)
    //                                         .build();
        
    //     System.out.println(">>>>>>>>>>>>> request dto, "+params);
    //     return null;
    // }
    
    @PostMapping("/post")
    public ResponseEntity<Void> save(BbsRequestDTO params) {
        System.out.println("debug >>> bbs controller client path/ post");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>request dto, " + params);
        bbsService.save(params);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //////////////////coment
    // comment 새 글을 작성
    // user endpoint : http://localhost:7777/api/bbs/comment/post?content=xxxx&bbsid=xxxx

    @PostMapping("/comment/save")
    public ResponseEntity<String> postMethodName(CommentRequestDTO params) {
        System.out.println("debug >>> bbs controller client path /comment/post");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>request dto, " + params);
        bbsService.commentSave(params);
        return new ResponseEntity<String>(params.getBbsid()+"에 타임라인 등록 완료!!",HttpStatus.OK);
    }
    
    
    
}
