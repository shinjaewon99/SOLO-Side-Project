package demoProject.shin.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @EnableWebSecurity 어노테이션은 웹 보안 (스프링 시큐리니)을 활성화 한다.
 * 하지만 그 자체로는 유용하지 않고, 스프링 시큐리티가 WebSecurityConfigurer를 구현하거나 컨텍스트의
 *  WebSebSecurityConfigurerAdapter를 확장한 빈으로 설정되어 있어야 한다.
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
// 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig {
    // 로그인이 성공했을 경우 처리해야 할 일 (스프링 시큐리티를 작업을 하는것임으로 세션에서 꺼내서 사용 X)
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    // 로그인이 실패했을 경우 처리해야 할 일
    private final AuthenticationFailureHandler authenticationFailureHandler;


    /**
     * SecurityFilterChain :
     * ServeltRequest 필터를 사용하는 방식
     * 스프링 시큐리티에서 필터들이 애플리케이션에 대한 모든 요청을 감싸서 처리합니다.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        /**
         * .csrf : 토큰이 포함되어있어야 요청을 받아드림, 위조 요청을 방지한다.
         * 이것을 disable()로 두는 이유는 서버에 인증정보를 저장하지 않기 때문에 굳이 불필요한 csrf 코드를 작성할 필요없다.
         */
        httpSecurity.csrf(
                httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()
        )
                .authorizeRequests(
                        authorizeRequests -> authorizeRequests
                                .an

                )

    }

}
