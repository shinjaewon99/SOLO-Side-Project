package demoProject.shin.service;


import demoProject.shin.dto.MemberDto;
import demoProject.shin.entity.Member;
import demoProject.shin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional // default 값은 false, true로 설정하게되면 읽기전용이 된다. (영속성 컨텍스트 관리 X, 변경감지(더티 체킹) 수행 X)
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberDto login(String username, String password, String mail, String nickName){

        Member member = Member.builder()
                .username(username)
                .password()
                .mail(mail)
                .nickName(nickName)
                .build();
    }
}
