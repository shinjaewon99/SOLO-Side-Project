package demoProject.shin.service;


import demoProject.shin.entity.Member;
import demoProject.shin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional // default 값은 false, true로 설정하게되면 읽기전용이 된다. (영속성 컨텍스트 관리 X, 변경감지(더티 체킹) 수행 X)
public class MemberService {

    private final MemberRepository memberRepository;

    // nickName 까지 입력하여 로그인 하는 로직
    public Member login(String username, String password, String mail, String nickName) {

        Member member = Member.builder()
                .username(username)
                .password()
                .mail(mail)
                .nickName(nickName)
                .build();

        // Spring Data Jpa를 사용하여, 기본적인 CRUD 메서드가 자동 생성
        memberRepository.save(member);
        return member;
    }

    // nickName을 입력하지 않더라도, 로그인이 되는 로직
    public Member login(String username, String password, String mail) {

        Member member = Member.builder()
                .username(username)
                .password()
                .mail(mail)
                .build();

        memberRepository.save(member);
        return member;
    }

    // true로 설정함으로써 읽기전용(상태가 변하지않았다) (변경 감지 X) 성능 증가
    @Transactional(readOnly = true)
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByName(username);
    }

    public Member findByMemberId(Long loginedMemberId){
        // orElse : 값이 없을 경우 값을 지정해줌
        Member memberFindId = memberRepository.findById(loginedMemberId).orElse(null);


        return memberFindId;
    }

    public void modifySubInform(Member member, String email, String nickname){
        member
    }
}
