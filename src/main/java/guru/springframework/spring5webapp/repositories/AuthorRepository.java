package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by laksheenmendis on 5/16/20 at 11:34 PM
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
