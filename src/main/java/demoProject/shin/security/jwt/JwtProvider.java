package demoProject.shin.security.jwt;

import demoProject.shin.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final SecretKey secretKey;

    private SecretKey getSecretKey() {
        return secretKey;
    }

    // 토큰이 secretKey로 분해되는 함수인지 확인
    public boolean verify(String token) {
        try {
            // Jwt 생성 (Builder 패턴)
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    /**
                     * Jwt 토큰은 String 형태로 생성된다.
                     * 사용하기 위한 형태로 하기위해 파싱해준다.
                     */
                    .parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // 토큰으로부터 정보 얻기
    public Map<String, Object> getClaims(String token) {
        String body = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("body", String.class);

        return JwtUtil.json.toMap(body);
    }

    //정보와 시크릿 키, 시간을 넣어 압축해 토큰 생성
    public String generateAccessToken(Map<String, Object> claims, long seconds) {
        long now = new Date().getTime();
        Date accessTokenExpiresIn = new Date(now + 1000L * seconds);

        return Jwts.builder()
                .claim("body", JwtUtil.json.toStr(claims))
                /**
                 * 토큰을 언제까지 사용할건지 시간 지정
                 */
                .setExpiration(accessTokenExpiresIn)
                /**
                 * 사용할 암호화 알고리즘과 HS256
                 */
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                // 값 세팅
                .compact();
    }

}
