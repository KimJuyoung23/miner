package com.kjh.vuebootbackend.dto;

import com.kjh.vuebootbackend.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardModifyDto {

    private Long no;
    private String title;
    private String content;
//    private String lastModifiedAt;
//    private LocalDateTime lastModifiedDate;

    public Board toEntity(){
        return Board.builder()
                .no(no)
                .title(title)
                .content(content)
                .build();
    }
}
