package org.zerock.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long mno;
    private String title;

    // 영화 이미지들도 같이 수집해 전달해야 하므로 내부적으로 리스트를 이용해 수집
    // you can specify the default directly on the field,
    // and annotate the field with @Builder.Default:
    @Builder.Default
    private List<MovieImageDTO> imageDTOList = new ArrayList<>();

    // 영화 평균 평점
    private double avg;

    // 리뷰 수 (jpa의 count())
    private int reviewCnt;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
