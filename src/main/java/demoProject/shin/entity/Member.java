package demoProject.shin.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String loginId;
    private String name;
    private String mail;
    private String password;


}
