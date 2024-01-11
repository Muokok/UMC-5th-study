package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.MissionDTO missionDTO(Mission mission){

        LocalDate now = LocalDate.now(); // 현재 날짜

        long dateGap = ChronoUnit.DAYS.between(now, mission.getDeadline()); // now와 DeadLine의 차이를 계산
        
        String deadLine = String.format("D-%d", dateGap); //데드라인을 화면 형식대로 가공
        
        return MissionResponseDTO.MissionDTO.builder()
                .storeName(mission.getStore().getName())
                .deadLine(deadLine)
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO missionListDTO(List<Mission> missionList){

        List<MissionResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MissionConverter::missionDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .listSize(missionList.size())
                .missionList(missionDTOList)
                .build();
    }
}
