package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    // 이 부분 이해 잘 안됨 >> 내장 함수인 것 같음. 해커톤(TS + Nest)때 썼던 메소드 느낌
    Page<Review> findAllByMember(Member member,PageRequest pageRequest);
}
