package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
