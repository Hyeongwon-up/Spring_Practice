package Hyeongwon.Spring_Practice.service;

import Hyeongwon.Spring_Practice.domain.Member;
import Hyeongwon.Spring_Practice.repository.MemberRepository;
import Hyeongwon.Spring_Practice.repository.MemoryMemberRepsitory;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepsitory();


    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복회원 x
        validateDuplicateMember(member);//중복회원 검

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체회원검증
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();

    }

    public Optional<Member> findone(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
