package org.zerock.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    // 리뷰 번호
    private Long reviewnum;

    // 영화 번호
    private Long mno;

    // 멤버 아이디
    private Long mid;
    // 멤버 닉네임
    private String nickname;
    // 멤버 이메일
    private String email;

    // 평점
    private int grade;
    // 리뷰 내용
    private String text;

    private LocalDateTime regDate, modDate;
}
