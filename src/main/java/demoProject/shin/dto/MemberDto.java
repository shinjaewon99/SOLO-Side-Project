package demoProject.shin.dto;

import demoProject.shin.entity.Member;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
// Dto View (Ui)에서 외부로 노출되는 정보를 막기위해 Dto 클래스를 따로 만들어줬다.
public class MemberDto {


    private String username;
    private String mail;
    private String password;

    public MemberDto(Member member) {
        this.username = member.getUsername();
        this.mail = member.getMail();
        this.password = member.getPassword();
    }
}
