package demoProject.shin.entity;

import demoProject.shin.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity {

    /**
     * N To One 조건은 LAZY : 지연로딩을 걸어줘야된다.
     * N To Many는 default 조건이 LAZY 이다.
     * Member 한명이 다양한 상품을 등록할수있다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Member author;
    private String title;
    private int price;



}
