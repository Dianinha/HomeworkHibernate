package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Article;

@Component
public interface ArticleRepository extends JpaRepository<Article, Long>{

	@Query(value="SELECT * FROM articles ORDER BY created DESC LIMIT 5", nativeQuery = true)
	List<Article> getLastFive();
}
