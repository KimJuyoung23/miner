package com.kjh.vuebootbackend.dto;

import com.kjh.vuebootbackend.Board;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDeleteDto {

    private String deleteYn;
    private Long bNo;
    private String title; // 없어야함
    private String bContent; // 없어야함

    public Board toEntity(){
        return Board.builder()
                .bNo(bNo)
                .deleteYn("y")
                .build();
    }
}
