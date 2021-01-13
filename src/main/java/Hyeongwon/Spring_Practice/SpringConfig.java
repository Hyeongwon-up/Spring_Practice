package Hyeongwon.Spring_Practice;


import Hyeongwon.Spring_Practice.repository.JdbcMemberRepository;
import Hyeongwon.Spring_Practice.repository.JpaMemberRepository;
import Hyeongwon.Spring_Practice.repository.MemberRepository;

import Hyeongwon.Spring_Practice.service.JdbcTemplateMemberRepository;
import Hyeongwon.Spring_Practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository() {


         // return new MemoryMemberRepository();
         // return new JdbcMemberRepository(dataSource);
         // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
