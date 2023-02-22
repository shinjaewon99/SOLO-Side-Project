package demoProject.shin.service;

import demoProject.shin.dto.MemberDto;
import demoProject.shin.entity.Member;

public interface MemberService {



    /**
     *
     *  스프링 데이터 JPA의 save메서드가 Entity가 파라미터임으로
     *  MemberDto 클래스를 Entity로 변환하는 로직이다.
     */

   default Member dtoToEntity(MemberDto memberDto){
       Member entity = Member.builder()
               .username(memberDto.getUsername())
               .mail(memberDto.getMail())
               .nickname(memberDto.getNickName())
               .build();
       return entity;
   }
}
