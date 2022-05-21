package org.zerock.mreview.repositroy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.repository.MemberRepository;
import org.zerock.mreview.repository.ReviewRepository;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // 멤버를 100명 추가하는 테스트 코드
//    @Test
//    public void insertMembers() {
//
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//
//            Member member = Member.builder()
//                    .email("r" + i + "@zerock.org")
//                    .pw("1111")
//                    .nickname("reviewer" + i)
//                    .build();
//
//            memberRepository.save(member);
//        });
//    }

    // 멤버를 삭제하는 테스트 코드 (멤버가 작성한 리뷰까지 삭제되어야 함)
    // Review 삭제 -> Member 삭제의 트랜잭션 처리가 필요
    @Commit
    @Transactional
    @Test
    public void testDeleteMember() {

        Long mid = 1L; // Member id

        Member member = Member.builder().mid(mid).build();

        // ** FK를 가지는 Review를 먼저 삭제해주어야 함 **
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }
}
