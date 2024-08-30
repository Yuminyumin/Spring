package com.example.springweb.test.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BbsRequestDTO {
    private int    id;
    private String title;
    private String content;
}
