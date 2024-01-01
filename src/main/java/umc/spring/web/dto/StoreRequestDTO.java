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
        // 여기에 왜 store_id랑 member_id가 없는건지??? 내 생각엔 member_id와 store_id가 각각 쿼라스트링, path variable로 받아와서라고 생각하는데 맞나?!
        // 그니까 request body로 받아와서 DTO로 변환하려는 값은 여기에 다 적어줘야 하고, 다른 방식(쿼리스트링, 파라미터)으로 받아오는 건 여기에 안 적어줘도
        // 되기 때문에 member_id랑 store_id가 없어도 되는 것 같다.
    }
}