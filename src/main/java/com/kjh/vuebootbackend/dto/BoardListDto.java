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

    private Long no;
    private String title;
    private String content;

    public BoardListDto(Board board) {
        this.no = no;
        this.title = title;
        this.content = content;
    }


}
