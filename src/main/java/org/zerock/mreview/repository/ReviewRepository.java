package org.zerock.mreview.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    // 특정 영화에 대한 리뷰 정보 리스트
    // EntityGraph는 엔티티의 특정한 속성을 같이 로딩하도록 표시함
    // ex) 특정 기능을 수행할 때만 EAGER 로딩을 하도록 지정 가능
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    // 회원을 이용해서 Review들을 삭제
    // update, delete를 위해서는 @Modifying 어노테이션 필요
    @Modifying
    //delete문이 3번 반복되고 마지막에 m_member 테이블에서 삭제가 이뤄지는 비효율을 Query로 방지
    @Query("delete from Review mr where mr.member = :member")
    void deleteByMember(Member member);
}
