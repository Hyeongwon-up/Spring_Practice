package Hyeongwon.Spring_Practice;


import Hyeongwon.Spring_Practice.aop.TimeTraceAop;
import Hyeongwon.Spring_Practice.repository.JpaMemberRepository;
import Hyeongwon.Spring_Practice.repository.MemberRepository;

import Hyeongwon.Spring_Practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

   // private final EntityManager em;
   // private final DataSource dataSource;

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) { this.memberRepository = memberRepository;
    }


    /*

    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }

    */


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);

    }

    /*
    @Bean
    public MemberRepository memberRepository() {


         // return new MemoryMemberRepository();
         // return new JdbcMemberRepository(dataSource);
         // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }



    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

    */



}
