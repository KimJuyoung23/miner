package com.kjh.vuebootbackend.dto;

import com.kjh.vuebootbackend.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BoardListDto {

    private Long bNo;
    private String title;
    private String bContent;

    public BoardListDto(Board board) {
        this.bNo = bNo;
        this.title = title;
        this.bContent = bContent;
    }


}
