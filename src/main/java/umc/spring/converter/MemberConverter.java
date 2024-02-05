package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDto toJoinResultDTO(Member member){ //이 부분은 응답에 대한 결과를 반환하는 것 같은데 맞는지? 아니라면 뭔지?
        return MemberResponseDTO.JoinResultDto.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){ //이 부분이 repository에서 받아온 엔티티를 dto로 바꾸는 과정??

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender= Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress()) // 여기서 get~~은 DTO에 있는 친구들만 가져올 수 있음.
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(MemberMission memberMission){
        return MemberResponseDTO.ChallengeMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toChallengeMission(MemberRequestDTO.ChallengeMissionDTO request){
        return MemberMission.builder()
                .build(); // 이거 왜 있는거임? 왜 만든거지 대체?
    }
}