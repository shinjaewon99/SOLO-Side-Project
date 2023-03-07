package demoProject.shin.security.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * @Configuration : 설정파일을 만들기 위한 어노테이션 or Bean 등록을 위한 어노테이션
 */
@Configuration
public class JwtConfig {

    // 이 키를 활용하여 Jwt 토큰을 만들고 나중에 요청이 들어오면 토큰을 해석할수있다.
    @Value("${custom.jwt.secretKey}")
    private String secretKey;


    // SecretKey 인터페이스 : id, pw를 확인후 맞다면 Jwt를 SecretKey로 생성한다.
    @Bean
    public SecretKey jwtSecretKey(){
        /*
        secretKey를 Base64 인코딩하여 받아온다.
        Base64 : 64진법이라는 의미, 실행 파일의 8비트 데이터를 공통 아스키 문자열로 바꾸는 인코딩 방식
        * */
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKey.getBytes());

        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());

    }
}
