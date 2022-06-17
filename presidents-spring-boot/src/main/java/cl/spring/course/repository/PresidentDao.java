package cl.spring.course.repository;

import cl.spring.course.domain.President;
import org.springframework.data.repository.CrudRepository;

public interface PresidentDao extends CrudRepository<President, Integer> {
}
