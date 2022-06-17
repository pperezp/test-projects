package cl.spring.course.service;

import cl.spring.course.domain.President;
import java.util.List;

public interface PresidentService {
    void save(President president);

    List<President> read();

    void delete(President president);

    President readById(Integer id);
}
