package demoProject.shin.repository.product;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Select;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA를 사용하지 않고 쿼리 작성
 */
@RequiredArgsConstructor
public class Product {

    // 생성자를 만들어서 사용해야 되지만,
    // @RequiredArgsConstructor 어노테이션을 사용하면 private이 붙은 변수의 생성자를 자동으로 만들어준다.
    private final EntityManager em;



    // NPE (Null Point Exception)을 처리하기위해 Optional로 감쌌다.
    public Optional<List<Product>> findAll(){
        return Optional.of(em.createQuery("select p from Product p", Product.class)
                .getResultList());
    }

}
