package demoProject.shin.repository;

import demoProject.shin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// JpaRepository <T (객체), pk type>
public interface MemberRepository extends JpaRepository<Member, Long> {

    // select m from Member m where m.name = ?  JPQL을 자동으로 생성 (스프링 데이터 Jpa를 사용했기때문)
    Optional<Member> findByName(String name);

    Optional<Member> findByEmail(String mail);

    Optional<Member> findByNameAndMail(String name, String mail);
}
