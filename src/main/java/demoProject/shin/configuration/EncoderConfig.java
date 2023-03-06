package demoProject.shin.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// @Bean을 등록하기위한 어노테이션
@Configuration
public class EncoderConfig {

    /**
     * 순환 참조 문제로 인해 SecurityConfig와 EncoderConfig 클래스를 분리한다.
     */

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 스프링 시큐리티에서 제공하는 비밀번호를 암호하 하는데 사용 할수있는 메서드를 가진 클래스
        return new BCryptPasswordEncoder();

    }
}
