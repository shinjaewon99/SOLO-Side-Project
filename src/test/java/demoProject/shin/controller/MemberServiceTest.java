package demoProject.shin.controller;

import demoProject.shin.entity.Member;
import demoProject.shin.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @WebMvcTest: Controller를 테스트하기 위한 어노테이션
 * Controller가 정상적으로 작동하는지 테스트하는 것이기 때문에 Web과 관련된 의존성만 가지고온다
 * @WebMvcTest
 */
@SpringBootTest
@Transactional
class MemberServiceTest {


    /*
    MockMvc 란 ?
    개발한 웹 프로그램을 실제 서버에 배포하지 않고도 테스트를 위한 요청을 제공하는 수단 (흉내낸다 생각)
    @Autowired
    MockMvc mockMvc;
    @MockBean
    * */


    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입 test")
    void join() {
        String username = "shin";
        String password = "12345";
        String email = "shin@test.com";
        String nickname = "hello";

        memberService.login(username, password, email, nickname);
        // Optional 타입은 get()으로 바로 꺼내면 안되지만, 테스트 코드임으로 get으로 바로 꺼냈다.
        Member findMember = memberService.findByUsername("shin").get();

        // Null 검증
        assertThat(findMember.getUsername()).isNotNull();

        /**
         * 로그인 검증
         * PasswordEncoder의 인터페이스 메서드(matches) 사용
         */
        assertThat(passwordEncoder.matches(password, findMember.getPassword())).isTrue();


    }

 /* MockMVC 테스트

    @Test
    @DisplayName("회원가입 test")
    void join_MOCK() throws Exception {
        String username = "shin";
        String password = "12345";

        mockMvc.perform(post("/member/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsByte(new UserJoinRequest(username,password))))
                .andDo(print())
                .andExpect(status().isOk());
    }*/
}