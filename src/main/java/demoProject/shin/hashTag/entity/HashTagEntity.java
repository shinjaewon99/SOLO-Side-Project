package demoProject.shin.hashTag.entity;

import demoProject.shin.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@ToString(callSuper = true) // false일 경우 부모의 toString을 출력하지 않는다.
public class HashTagEntity extends BaseEntity {

    @ManyToOne // 여러 도서 상품의 하나의 저자
    @ToString.Exclude // toString() 결과에서 제외
    private

    @ManyToOne // 여러 도서 상품의 하나의 키워드
    @ToString.Exclude
    private
}
