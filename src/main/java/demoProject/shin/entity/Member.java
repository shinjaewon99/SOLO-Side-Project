package demoProject.shin.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
/**
 * @Builder 처럼 어떤 객체의 필드값을 편하게 저장하기 위해 사용한다. super가 붙었음으로 부모 객체를 상속받는 자식객체에서
 * 부모 객체의 필드값도 저장할수 있게 하기 위해서 사용
 */
@SuperBuilder

public class Member {

    @Column(unique = true)
    private String username;  // 로그인 Id



    private String loginId;

    private String mail;
    private String password;
    private String nickName;



}
