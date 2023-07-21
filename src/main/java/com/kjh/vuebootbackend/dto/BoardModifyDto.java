package com.kjh.vuebootbackend.dto;

import com.kjh.vuebootbackend.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardModifyDto {

    private Long bNo;
    private String title;
    private String bContent;
//    private String lastModifiedAt;
//    private LocalDateTime lastModifiedDate;

    public Board toEntity(){
        return Board.builder()
                .bNo(bNo)
                .title(title)
                .bContent(bContent)
                .build();
    }
}
