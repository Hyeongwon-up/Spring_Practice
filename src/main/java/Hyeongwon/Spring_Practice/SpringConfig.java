package Hyeongwon.Spring_Practice;


import Hyeongwon.Spring_Practice.repository.MemberRepository;
import Hyeongwon.Spring_Practice.repository.MemoryMemberRepsitory;
import Hyeongwon.Spring_Practice.service.MemberService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepsitory();
    }

}
