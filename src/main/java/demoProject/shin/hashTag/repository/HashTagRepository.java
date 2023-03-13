package demoProject.shin.hashTag.repository;

import demoProject.shin.hashTag.dto.HashTagDto;
import demoProject.shin.hashTag.entity.HashTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// value 값이 Long인 이유는 BaseEntity로 Id값을 설정하였다.
public interface HashTagRepository extends JpaRepository<HashTagEntity, Long> {

    List<HashTagDto> findAllByArticleId(Long articleId);

    Optional<HashTagDto> findByArticleIdAndKeywordId(Long articleId, Long keywordId);

}
