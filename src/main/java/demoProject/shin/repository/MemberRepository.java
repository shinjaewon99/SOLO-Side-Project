package demoProject.shin.repository;

import demoProject.shin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);

    Optional<Member> findByEmail(String mail);

    Optional<Member> findByNameAndMail(String name, String mail);
}
