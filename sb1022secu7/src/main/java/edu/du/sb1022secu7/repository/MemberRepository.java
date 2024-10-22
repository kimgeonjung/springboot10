package edu.du.sb1022secu7.repository;

import edu.du.sb1022secu7.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUsername(String username);
    Optional<Member> findByEmail(String email);
}
