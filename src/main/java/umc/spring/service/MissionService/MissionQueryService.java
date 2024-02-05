package umc.spring.service.MissionService;

import umc.spring.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long missionId);
    // Mission findMission(Long missionId)가 아니라 Optional<Mission>라고 하는 이유가 뭐임?

    List<Mission> getMissionList(Long storeId);
}
