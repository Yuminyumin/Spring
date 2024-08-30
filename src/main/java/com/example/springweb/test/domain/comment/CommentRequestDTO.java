package com.example.springweb.test.domain.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentRequestDTO {
    private String content;
    private Integer bbsid;
}
