package Hyeongwon.Spring_Practice;


import Hyeongwon.Spring_Practice.repository.JdbcMemberRepository;
import Hyeongwon.Spring_Practice.repository.MemberRepository;
import Hyeongwon.Spring_Practice.repository.MemoryMemberRepsitory;
import Hyeongwon.Spring_Practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository() {


        return new JdbcMemberRepository(dataSource);
        //return new MemoryMemberRepsitory();
    }

}
