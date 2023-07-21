package com.kjh.vuebootbackend;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
//@Setter
@NoArgsConstructor
@Table(name = "board")
@Entity
@DynamicInsert
public class Board extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_no")
    private Long bNo;

    @Column(name = "title",length = 50,nullable = false)
    private String title;

    @Column(name = "b_content", columnDefinition = "TEXT",nullable = false)
    private String bContent;

    @Column(name = "delete_yn")
    @ColumnDefault("'n'") //디폴트 N으로 설정되게
    private String deleteYn;

    @Column(name = "views")
    @ColumnDefault("0")
    private Long views;

    @Column(name = "thumbs_up")
    @ColumnDefault("0")
    private Long thumbsUp;

    @CreatedBy
    @Column(name = "CREATED_AT", updatable = false)
//    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    private String createdAt;

//    @CreatedDate
//    @Column(name = "CREATED_DATE", updatable = false, nullable = false)
//    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_AT")
    private String lastModifiedAt;

//    @LastModifiedDate
//    @Column(name = "LAST_MODIFIED_DATE")
//    private LocalDateTime lastModifiedDate;

    @Builder
    public Board(Long bNo, String title, String bContent, String deleteYn) {
        this.bNo = bNo;
        this.title = title;
        this.bContent = bContent;
        this.deleteYn = deleteYn;
    }
}
