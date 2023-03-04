package demoProject.shin.controller;

import demoProject.shin.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest: Controller를 테스트하기 위한 어노테이션
 * Controller가 정상적으로 작동하는지 테스트하는 것이기 때문에 Web과 관련된 의존성만 가지고온다
 */
@WebMvcTest
class MemberControllerTest {


    /*
    MockMvc 란 ?
    개발한 웹 프로그램을 실제 서버에 배포하지 않고도 테스트를 위한 요청을 제공하는 수단 (흉내낸다 생각)
    * */
    @Autowired
    MockMvc mockMvc;

    @MockBean
    @Autowired
    MemberServiceImpl memberService;

    @Test
    @DisplayName("회원가입 test")
    void join() {
        String username = "shin";
        String password = "12345";
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