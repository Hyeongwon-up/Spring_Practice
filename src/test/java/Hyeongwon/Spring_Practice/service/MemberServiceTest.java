package Hyeongwon.Spring_Practice.service;

import Hyeongwon.Spring_Practice.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {



    MemberService memberService = new MemberService();


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when

        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findone(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findone() {
    }
}