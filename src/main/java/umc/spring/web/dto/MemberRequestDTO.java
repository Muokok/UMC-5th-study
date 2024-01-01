package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.Mission;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

    @Getter
    public static class ChallengeMissionDTO{
        @NotNull
        Long missionId;
        //여기서 Long missionId로 갈지, Mission mission 으로 갈지 어떻게 해야할까??
    }
}