package com.kjh.vuebootbackend;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;


@Getter
//@Setter
@NoArgsConstructor
@Table(name = "board")
@Entity
@DynamicInsert
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @Column(name = "title",length = 50,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    @Column(name = "delete_yn")
    @ColumnDefault("'n'") //디폴트 N으로 설정되게
    private String deleteYn;

//    @NonNull
//    @Column(name = "b_content",columnDefinition = "TEXT")
//    private String bContent;
//
//    @Column(name = "VIEWS")
//    private Integer views;
//
//    @Column(name = "THUMBS_UP")
//    private Integer thumbsUp;
//
//    @CreatedBy
//    @Column(name = "CREATED_AT")
//    private String createdAt;
//
//    @CreatedDate
//    @Column(name = "CREATED_DATE", updatable = false)
//    private LocalDateTime createdDate;
//
//    @LastModifiedBy
//    @Column(name = "LAST_MODIFIED_AT")
//    private String lastModifiedAt;
//
//    @LastModifiedDate
//    @Column(name = "LAST_MODIFIED_DATE")
//    private LocalDateTime lastModifiedDate;

    @Builder
    public Board(Long no, String title, String content, String deleteYn) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.deleteYn = deleteYn;
    }
}
