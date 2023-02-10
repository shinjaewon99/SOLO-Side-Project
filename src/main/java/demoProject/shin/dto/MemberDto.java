package demoProject.shin.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberDto {

    private Long id;

    @NotEmpty
    private String loginId; // 로그인 ID
    @NotEmpty
    private String name;
    @NotEmpty
    private String mail;
    @NotEmpty
    private String password;




}
