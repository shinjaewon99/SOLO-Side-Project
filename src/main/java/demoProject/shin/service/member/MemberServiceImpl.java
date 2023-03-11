package demoProject.shin.service.member;


import demoProject.shin.dto.member.MemberDto;
import demoProject.shin.entity.Member;
import demoProject.shin.exception.ExceptionManger;
import demoProject.shin.repository.member.MemberRepository;
import demoProject.shin.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional // default 값은 false, true로 설정하게되면 읽기전용이 된다. (영속성 컨텍스트 관리 X, 변경감지(더티 체킹) 수행 X)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;

    // nickName 까지 입력하여 로그인 하는 로직
    public Member login(String username, String password, String mail, String nickName) {

        /**
         * ifPresent() = Optional 객체가 값을 가지고 있으면 실행 아니면 넘어감
         * 예외로 isPresent() = Optional 객체가 값을 가지고 있으면 true, 아니면 false
         * username 중복 체크
         */
        memberRepository.findByUserName(username)
                .ifPresent(member -> {
                    throw new ExceptionManger(username + "는 이미 있습니다.");
                });

        Member member = Member.builder()
                .username(username)
                /*
                encode : Spring Security에서는 비밀번호를 안전하게 저장할 수 있도록 인터페이스 제공
                 */
                .password(passwordEncoder.encode(password))
                .mail(mail)
                .nickname(nickName)
                .authLevel(4)
                .build();

        // Spring Data Jpa를 사용하여, 기본적인 CRUD 메서드가 자동 생성
        memberRepository.save(member);
        return member;
    }

    // nickName을 입력하지 않더라도, 로그인이 되는 로직
    public Member login(String username, String password, String mail) {
        memberRepository.findByUserName(username)
                .ifPresent(member -> {
                    throw new ExceptionManger(username + "는 이미 있습니다.");
                });
        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .mail(mail)
                .authLevel(3)
                .build();

        memberRepository.save(member);
        return member;
    }

    // true로 설정함으로써 읽기전용(상태가 변하지않았다) (변경 감지 X) 성능 증가
    @Transactional(readOnly = true)
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUserName(username);
    }

    public Member findByMemberId(Long loginedMemberId){
        // Optional에서 지원하는 기능 orElse : 값이 없을 경우 값을 지정해줌
        return memberRepository.findById(loginedMemberId).orElse(null);
    }

    public void modifySubInform(MemberDto memberDto, String email, String nickname){
        /**
         * 엔티티 클래스는 최대한 Setter를 자제해야 함으로, MemberDto 클래스를 만들어 줌으로써 값을 바인딩하였다.
         */
        memberDto.setMail(email);
        memberDto.setNickName(nickname);
        // Dto클래스를 엔티티 클래스로 변환
        Member member = dtoToEntity(memberDto);
        memberRepository.save(member);
    }

    public void modifyPassword(MemberDto memberDto, String beforePassword){
        memberDto.setPassword(passwordEncoder.encode(beforePassword));
        Member member = dtoToEntity(memberDto);
        memberRepository.save(member);
    }

    // 비밀번호 확인
    public boolean checkPassword(MemberDto memberDto, String beforePassword){

        // 암호화된 비밀번호가 같은지 확인
        if(passwordEncoder.matches(beforePassword, memberDto.getPassword())){
            return true;
        }
        return false;
    }

    public String joinedEmail(String mail){

        Member member = memberRepository.findByEmail(mail).orElse(null);

        // 등록된 이메일이 아닌경우
        if(member == null){
            return null;
        }
        return member.getUsername();
    }


    public Member findById(Long id){
        Member member = memberRepository.findById(id).orElse(null);
        return member;
    }



}
