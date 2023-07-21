package com.kjh.vuebootbackend.dto;

import com.kjh.vuebootbackend.Board;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardWriteDto {
    private String title;
    private String bContent;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .bContent(bContent)
                .build();
    }

}
