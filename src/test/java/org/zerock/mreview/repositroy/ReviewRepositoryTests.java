package org.zerock.mreview.repositroy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;
import org.zerock.mreview.repository.ReviewRepository;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    // 생성된 멤버, 영화 정보를 바탕으로 리뷰 더미데이터 200개 추가하는 테스트 코드
//    @Test
//    public void insertReviews() {
//        IntStream.rangeClosed(1, 200).forEach(i -> {
//
//            // 리뷰할 영화 번호
//            Long mno = (long)(Math.random() * 100) + 1;
//            // 리뷰할 영화 정보
//            Movie movie = Movie.builder().mno(mno).build();
//
//            // 리뷰하는 멤버 아이디
//            Long mid = (long)(Math.random() * 100) + 1;
//            // 리뷰하는 멤버 정보
//            Member member = Member.builder().mid(mid).build();
//
//            Review review = Review.builder()
//                    .movie(movie)
//                    .member(member)
//                    .grade((int)(Math.random() * 5) + 1)
//                    .text("이 영화에 대한 느낌..." + i)
//                    .build();
//
//            reviewRepository.save(review);
//        });
//    }

    // 특정 영화 리뷰 리스트 테스트
    @Test
    public void testFindByMovie() {

        Movie movie = Movie.builder().mno(92L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {
            System.out.println(movieReview.getReviewnum());
            System.out.println("\t" + movieReview.getGrade());
            System.out.println("\t" + movieReview.getText());
            System.out.println("\t" + movieReview.getMember().getEmail());
            System.out.println("=========================================");
        });
    }
}
