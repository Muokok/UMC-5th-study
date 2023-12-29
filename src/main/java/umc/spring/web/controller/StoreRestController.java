package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController { // ReviewRestController가 아니라 어째서 StoreRestController인지?
    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewResultDto> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDto request,
                                                                      @PathVariable(name = "memberId") Long memberId,
                                                                      @PathVariable(name = "storeId") Long storeId){ // 예외처리 어노테이션 만들어줘야 함
        Review review = storeCommandService.createReview(memberId, storeId,request);
        return ApiResponse.onSuccess(StoreConverter.toReviewResultDTO(review));
    }

}
