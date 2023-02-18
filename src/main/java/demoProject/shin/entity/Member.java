package demoProject.shin.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
/**
 * @Builder 처럼 어떤 객체의 필드값을 편하게 저장하기 위해 사용한다. super가 붙었음으로 부모 객체를 상속받는 자식객체에서
 * 부모 객체의 필드값도 저장할수 있게 하기 위해서 사용
 */
@SuperBuilder
//@Setter 엔티티에서는 최대한 Setter는 자제해야된다.

public class Member {

    @Column(unique = true)
    private String username;  // 로그인 Id



    private String mail;
    private String password; //외부에 노출되서는 안 될 정보임.
    private String nickname;


    // 엔티티 클래스는 기본적으로 default 생성자가 있어야함 ( JPA에서 프록시 등등으로사용)
    protected Member() {
    }

    public void SubInformMemberUpdate(String mail, String nickname) {
        this.mail = mail;
        this.nickname = nickname;
    }


}
