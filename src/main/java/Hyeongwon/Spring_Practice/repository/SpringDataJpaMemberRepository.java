package Hyeongwon.Spring_Practice.repository;


import Hyeongwon.Spring_Practice.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
        Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}