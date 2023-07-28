package com.kjh.vuebootbackend;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;



//@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@Getter
//@Setter
@NoArgsConstructor // 생성자.
@RequiredArgsConstructor // 생성자. @NonNull 값은 필수 값이 됨
@AllArgsConstructor // 생성자.
@Table(name = "board") // 클래스 명이 기본값
@Entity //@Id (pk )
@DynamicInsert
public class Board extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType : TABLE,SEQUENCE,IDENTITY,UUID,AUTO
    @Column(name = "b_no") //
    private Long bNo;

    @Column(name = "title",length = 50,nullable = false)
    // @Column(unique = true) // @Table의 UniqueConstraint 값 설정
    // @Table(UniqueConstraint = {@uniqueConstraints(columnNames = {"title"})})
    private String title;

    @Column(name = "b_content", columnDefinition = "TEXT",nullable = false)
    private String bContent;

    @Column(name = "delete_yn")
    @ColumnDefault("'n'") //디폴트 N으로 설정. Post 에는 null 값으로 들어감. DB 저장되고 'N' 으로 변경되는 거 같음.
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

    @Transient // DB에 영향 없음. DB 영속성 배제?
    private String testData;


//    @Enumerated(value = EnumType.STRING) // EnumType.ORDINAL 기본값이라 오류 발생 가능.
//    private Gender Gender;

    @Builder
    public Board(Long bNo, String title, String bContent, String deleteYn) {
        this.bNo = bNo;
        this.title = title;
        this.bContent = bContent;
        this.deleteYn = deleteYn;
    }
}
