package org.zerock.mreview.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 해당 클래스가 상속될 속성을 포함하고 있는 슈퍼 클래스임을 알림
// (부모클래스(BaseEntity)에 선언하고, 속성만 상속받아 사용하고 싶을 때)
@MappedSuperclass
//Auditing기능을 수행하는 리스너를 등록
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {

    @CreatedDate // 날짜 생성
    @Column(name = "regdate", updatable = false) // 업데이트 가능 X
    private LocalDateTime regDate;

    @LastModifiedDate // 마지막으로 수정된 날짜
    @Column(name = "moddate") // 업데이트 가능 O
    private LocalDateTime modDate;
}
