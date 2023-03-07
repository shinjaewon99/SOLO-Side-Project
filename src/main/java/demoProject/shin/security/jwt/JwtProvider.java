package demoProject.shin.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final SecretKey secretKey;

    private SecretKey getSecretKey(){
        return secretKey;
    }

    // 토큰이 secretKey로 분해되는 함수인지 확인
}
