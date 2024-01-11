package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Optional<Mission> findMission(Long missionId) {
        return missionRepository.findById(missionId);
    }

    @Override
    public List<Mission> getMissionList(Long storeId) {

        Store store = storeRepository.findById(storeId).get();

        List<Mission> missionList = missionRepository.findAllByStore(store);

        return missionList;
    }
}
