package org.zerock.mreview.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie") // 연관 관계가 있으니 주의
public class MovieImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;

    private String uuid; // java.util.UUID 통해 고유 번호 생성 후 사용

    private String imgName;

    private String path; // 저장 경로는 년/월/일 폴더 구조를 의미

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
