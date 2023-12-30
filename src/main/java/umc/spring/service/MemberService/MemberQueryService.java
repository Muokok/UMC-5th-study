package umc.spring.service.MemberService;

import umc.spring.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long memberId);
    // Member findeMember(Long memberId)가 아니라 Optional<Member>라고 하는 이유가 뭐임?

}
