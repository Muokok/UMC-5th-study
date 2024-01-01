package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController { // ReviewRestController가 아니라 어째서 StoreRestController인지? >> store에 대한 리뷰가 들어온 것이니..?
    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewResultDto> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDto request,
                                                                      @ExistMember @RequestHeader(name = "memberId") Long memberId,
                                                                      @ExistStore @PathVariable(name = "storeId") Long storeId){ // 예외처리 어노테이션 만들어줘야 함
        Review review = storeCommandService.createReview(memberId, storeId,request);
        return ApiResponse.onSuccess(StoreConverter.toReviewResultDTO(review));
    }
}
