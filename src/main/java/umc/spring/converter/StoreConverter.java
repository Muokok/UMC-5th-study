package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.ReviewResultDto toReviewResultDTO(Review review){
        return StoreResponseDTO.ReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.ReviewDto request){
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
