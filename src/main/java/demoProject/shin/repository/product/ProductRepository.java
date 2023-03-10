package demoProject.shin.repository.product;


import demoProject.shin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Spring Data Jpa의 메서드 키워드를 통해 내림차순으로 정리가된다.
    List<Product> findAllByOrderByIdDesc();
}
