package demoProject.shin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// 모든 엔티티에 들어가는 공통 컬럼들을 공통Entity를 뽑아내서 사용할때 사용 (대표적으로, 등록일자 수정일자)
@EnableJpaAuditing
public class ShinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShinApplication.class, args);
	}

}
