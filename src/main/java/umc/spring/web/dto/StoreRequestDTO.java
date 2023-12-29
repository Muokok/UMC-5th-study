package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.Member;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class ReviewDto{
        @NotBlank
        String body;
        @NotNull
        Float score;
        @NotBlank
        String title;
        // 여기에 왜 member_id가 없지???
    }
}
