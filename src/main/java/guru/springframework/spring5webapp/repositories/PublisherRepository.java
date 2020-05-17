package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by laksheenmendis on 5/17/20 at 1:16 AM
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
