package org.zerock.mreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//Spring Data JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능 (ex)update 할 때
@EnableJpaAuditing
public class MreviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(MreviewApplication.class, args);
    }

}
