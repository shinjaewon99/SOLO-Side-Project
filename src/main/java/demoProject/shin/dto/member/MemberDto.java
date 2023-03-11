package demoProject.shin.dto.member;

import demoProject.shin.entity.Member;
import lombok.*;



@Data
// Dto View (Ui)에서 외부로 노출되는 정보를 막기위해 Dto 클래스를 따로 만들어줬다.
@Builder
@Getter
@Setter
public class MemberDto {


    private String username;
    private String mail;

    private String password;
    private String nickName;

    public MemberDto(Member member) {
        this.username = member.getUsername();
        this.mail = member.getMail();
        this.password = member.getPassword();
        this.nickName = member.getNickname();

    }

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .mail(mail)
                .password(password)
                .nickname(nickName)
                .build();
    }
}
