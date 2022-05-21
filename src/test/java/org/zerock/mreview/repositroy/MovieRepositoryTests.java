package org.zerock.mreview.repositroy;

import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.MovieImage;
import org.zerock.mreview.repository.MovieImageRepository;
import org.zerock.mreview.repository.MovieRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class MovieRepositoryTests {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository movieImageRepository;

    //영화와 영화 이미지를 추가하는 테스트 코드
//    @Commit
//    @Transactional
//    @Test
//    public void insertMovies() {
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//
//            Movie movie = Movie.builder().title("Movie..." + i).build();
//
//            System.out.println("---------------------------------------");
//
//            movieRepository.save(movie); // 여기서 mno가 생성되면 그를 이용해 이미지 추가
//
//            int count = (int) (Math.random() * 5) + 1; // 1, 2, 3, 4, 5
//
//            for (int j = 0; j < count; j++) {
//                MovieImage movieImage = MovieImage.builder()
//                        .uuid(UUID.randomUUID().toString())
//                        .movie(movie)
//                        .imgName("test" + j + ".jpg")
//                        .build();
//
//                movieImageRepository.save(movieImage);
//            }
//
//            System.out.println("=============================================");
//        });
//    }

    //페이징 처리된 리스트 받아오기 테스트
//    @Test
//    public void testListPage() {
//
//        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "mno"));
//
//        Page<Object[]> result = movieRepository.getListPage(pageRequest);
//
//        for (Object[] objects : result.getContent()) {
//            System.out.println(Arrays.toString(objects));
//        }
//    }

    // 영화 정보 받아오기 테스트
    @Test
    public void testGetMovieWithAll() {

        List<Object[]> result = movieRepository.getMovieWithAll(94L);

        System.out.println(result);

        for (Object[] objects : result) {
            System.out.println(Arrays.toString(objects));
        }
    }
}
