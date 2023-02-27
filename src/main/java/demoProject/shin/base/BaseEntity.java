package demoProject.shin.base;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @EntityListeners : 해당 클래스에 Auditing 기능을 포함하는 어노테이션
 */
@EntityListeners(AuditingEntityListener.class)

/**
 * @MappedSuperclass : 엔티티 별로 공통 필드가 존재하는 경우 불 필요한 중복 코드를 제거하기 위해 사용한다.
 */
@MappedSuperclass
/**
 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
 * : 기본 생성자를 자동으로 생성해주고, 접근 지자를 JPA 규약에서 PROTECTED까지 허용한다.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BaseEntity extends BaseTimeEntity {

    @Id
    /*
    기본 키 생성을 데이터 베이스에 위임한다. (MySQL에서 많이 사용)
    데이터베이스에 값을 저장하고 나서야 기본 키 값을 구할수있다.
    */
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    @Transient // 아래 필드가 DB 필드가 되는 것을 막는다.
    @Builder.Default
    /*
    HashMap != LinkedHashMap
    간단히 말해 .put() 할시 HashMap은 순서대로 저장되지 않음, LinkedHashMap은 순서대로 저장된다.
    */
    private Map<String, Object> extra = new LinkedHashMap<>();
}
