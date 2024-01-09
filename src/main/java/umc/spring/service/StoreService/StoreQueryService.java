package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long storeId);

    Page<Review> getReviewList(Long storeId, Integer page);
    // 위 Page는 Spring Data JPA에서 제공하는 Paging을 위한 추상화를 제공함.
    Page<Review> getMyReviewList(Long memberId, Integer page);
}
